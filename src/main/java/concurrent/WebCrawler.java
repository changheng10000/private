package concurrent;

import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by changheng on 17/11/22.
 */
public abstract class WebCrawler {
    private volatile TrackingExecutor exec;
    private final Set<URL> urlsToCrawl = new HashSet<>();

    public synchronized void start(){
        exec = new TrackingExecutor(Executors.newCachedThreadPool());
        for(URL url : urlsToCrawl){
            submitCrawlTask(url);
        }
        urlsToCrawl.clear();
    }

    private void submitCrawlTask(URL url) {
        exec.execute(new CrawlTask(url));
    }

    public synchronized void stop() throws InterruptedException {
        try{
            saveUncrawled(exec.shutdownNow());
            if(exec.awaitTermination(10000, TimeUnit.MILLISECONDS)){
                saveUncrawled(exec.getCancelledTasks());
            }
        }finally {
            exec = null;
        }
    }

    protected abstract List<URL> processPage(URL url);

    private void saveUncrawled(List<Runnable> runnables) {
        for (Runnable runnable : runnables){
            urlsToCrawl.add( ((CrawlTask)runnable).getPage() );
        }
    }

    private class CrawlTask implements Runnable {
        private final URL url;
        public CrawlTask(URL url) {
            this.url = url;
        }

        @Override
        public void run() {
            for(URL link : processPage(url)){
                if(Thread.currentThread().isInterrupted()){
                    return;
                }
                submitCrawlTask(link);
            }
        }

        public URL getPage(){
            return url;
        }
    }
}

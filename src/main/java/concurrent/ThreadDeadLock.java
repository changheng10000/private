package concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by changheng on 17/11/23.
 */
public class ThreadDeadLock {
    ExecutorService exec = Executors.newSingleThreadExecutor();

    public class RenderPageTask implements Callable<String>{
        @Override
        public String call() throws Exception {
            Future<String> header, footer;
            header = exec.submit(new LoadFileTask("header.html", 3000));
//            footer = exec.submit(new LoadFileTask("footer.html", 5000));
            return header.get();
        }
    }

    class LoadFileTask implements Callable<String>{
        private final String html;
        private final long sleepTime;

        LoadFileTask(String html, long sleepTime){
            this.html = html;
            this.sleepTime = sleepTime;
        }

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public String call() throws Exception {
            System.out.println(html);
            Thread.sleep(sleepTime);
            return html+" has been rendered!";
        }

    }

    public void start() throws Exception{
        Future<String> submit = exec.submit(new RenderPageTask());
        System.out.println(submit.get());
    }

    public static void main(String[] args) throws Exception{
//        ThreadDeadLock threadDeadLock = new ThreadDeadLock();
//        threadDeadLock.start();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

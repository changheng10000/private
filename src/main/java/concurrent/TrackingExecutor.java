package concurrent;

import java.util.*;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by changheng on 17/11/22.
 */
public class TrackingExecutor extends AbstractExecutorService {
    private final ExecutorService exec;
    private final Set<Runnable> taskCancellecAtShutDwon = Collections.synchronizedSet(new HashSet<>());

    public TrackingExecutor(ExecutorService exec){
        this.exec = exec;
    }

    public List<Runnable> getCancelledTasks(){
        if(!exec.isTerminated()){
            throw new IllegalStateException();
        }

        return new ArrayList<>(taskCancellecAtShutDwon);
    }

    @Override
    public void shutdown() {
        exec.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        return exec.shutdownNow();
    }

    @Override
    public boolean isShutdown() {
        return exec.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return exec.isTerminated();
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return exec.awaitTermination(1000,TimeUnit.MILLISECONDS);
    }

    @Override
    public void execute(final Runnable command) {
        exec.execute(() -> {
            try{
                command.run();
            }finally {
                if(isShutdown() && Thread.currentThread().isInterrupted()){
                    taskCancellecAtShutDwon.add(command);
                }
            }
        });
    }
}

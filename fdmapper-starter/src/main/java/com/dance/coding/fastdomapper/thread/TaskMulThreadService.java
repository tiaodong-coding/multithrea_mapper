package com.dance.coding.fastdomapper.thread;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * 多线程处理任务封装类
 * className: TaskMulThreadService
 *
 * @version 1.0
 *          Date Time: a
 */
public class TaskMulThreadService<T, V> implements IMulThreadService<T, V> {
    protected ITaskHandle<T, V> taskHandle;
    private Integer maxThread;
    private Long maxWait;
    protected Queue<T> queue;
    private CyclicBarrier cyclicBarrier;
    private List<V> resultList =  Collections.synchronizedList(new ArrayList());

    private TaskMulThreadService(){}
    private TaskMulThreadService(ITaskHandle<T,V> taskHandle, Integer maxThread, Long maxWait){
        this.taskHandle=taskHandle;
        this.maxThread=maxThread;
        this.maxWait=maxWait;
    }
    public TaskMulThreadService(ITaskHandle<T,V> taskHandle, Integer maxThread){
        this(taskHandle,maxThread,Long.MAX_VALUE);
    }
    public TaskMulThreadService(ITaskHandle<T,V> taskHandle){
        this(taskHandle, 10);
    }
    /**
     * Created with IntelliJ IDEA.
     * 执行任务，返回所有执行的结果
     * className: TaskMulThreadService
     *
     * @version 1.0
     * Date Time:
     */
    @Override
    public List<V> execute(List<T> task) {
        queue = new ConcurrentLinkedQueue<T>(task);
        ExecutorService exec = Executors.newFixedThreadPool(maxThread);
        cyclicBarrier = new CyclicBarrier(maxThread + 1);
        for(int i  = 0;i<maxThread;i++){
            exec.execute(new TaskItemThread());
        }
        try {
            cyclicBarrier.await(maxWait, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            exec.shutdown();
        }
        return resultList;
    }

    /**
     * @param '' 传递参数
     * @return a 返回类型
     * @throw
     * @Title: a
     * @Description: 任务处理线程
     */
    class TaskItemThread implements Runnable{
        @Override
        public void run() {
            while (!queue.isEmpty()) {
                T t = queue.poll();
                resultList.add(taskHandle.execute(t));
            }
            try {
                cyclicBarrier.await(maxWait, TimeUnit.SECONDS);
            } catch (Exception e) {
               e.printStackTrace();
            }
        }
    }
}

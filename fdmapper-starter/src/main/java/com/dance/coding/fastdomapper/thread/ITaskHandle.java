package com.dance.coding.fastdomapper.thread;

/**
 * Created with IntelliJ IDEA.
 * 任务处理接口
 * className: ITaskHandle
 *
 * @version 1.0
 *          Date Time: a
 */
public interface ITaskHandle<T,V> {
    /**
     * Created with IntelliJ IDEA.
     * 执行任务，返回所有执行的结果
     * className: TaskMulThreadService
     *
     * @version 1.0
     * Date Time:
     */
    public V execute(T t);
}

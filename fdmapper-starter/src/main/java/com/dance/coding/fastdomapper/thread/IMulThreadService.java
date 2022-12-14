package com.dance.coding.fastdomapper.thread;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * 多线程处理任务接口
 * className: IMulThreadService
 *
 * @version 1.0
 *          Date Time: a
 */
public interface IMulThreadService<T,V> {
    /**
     * Created with IntelliJ IDEA.
     * 执行任务，返回所有任务的结果集合
     * className: IMulThreadService
     *
     * @version 1.0
     * Date Time:
     */
    public List<V> execute(List<T> task);
}

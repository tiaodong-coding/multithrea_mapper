package com.dance.coding.fastdomapper.thread;

/**
 * Created with IntelliJ IDEA.
 * 获取任务项接口
 * className: ITaskItem
 *
 * @version 1.0
 */
public interface ITaskItem<T> {
    /**
    * @Description: 获取一批任务
     */
    public T[] getTaskItem();
}

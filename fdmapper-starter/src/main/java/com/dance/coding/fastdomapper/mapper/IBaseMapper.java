package com.dance.coding.fastdomapper.mapper;

import java.util.List;
import java.util.concurrent.Future;

/**
 * 基础mapper接口
 * Created by ddzhan on 2019/8/20.
 */
public interface IBaseMapper<T,S> {
	
	/**
	 * 单个mapper
	 * @param source  
	 * @param t
	 * @return
	 */
	T mapper(S source,T t);

	
	/**
	 * 单个异步mapper
	 * @param source  
	 * @param t
	 * @return
	 */
    Future<T> mapperAsync(S source,T t);
    
    /**
	 * list mapper
	 * @param sourceList
	 * @param t
	 * @return
	 */
    List<T> mapper(List<S> sourceList ,T t);
    
    /**
   	 * list 异步 mapper
   	 * @param sourceList
   	 * @param t
   	 * @return
   	 */
    Future<List<T>> mapperAsync(List<S> sourceList ,T t);
}

package com.dance.coding.fastdomapper.mapper;

import java.util.List;
import java.util.concurrent.Future;

import com.dance.coding.fastdomapper.convert.impl.CorpDozerConvert;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;


/**
 * 抽象的mapper
 * Created by ddzhan on 2019/12/16.
 * @param <T>
 */
public abstract class Mapper<T,S> extends CorpDozerConvert implements IBaseMapper<T, S> {
	/**
	 * 单个同步mapper
	 */
	@Override
	public T mapper(S source,T target) {
		target = synchronousSingle(source,target);
		return target;
	}
	
	/**
	 * 单个异步mapper
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Async
	public Future<T> mapperAsync(S source, T target) {
		target = synchronousSingle(source,target);
		return new AsyncResult<>(target);
	}
	
	/**
	 * list 同步mapper
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> mapper(List<S> souceList, T target) {
		return asyncList(souceList, target);
	}
	
	
	/**
	 * list 异步mapper
	 */
	@Override
	@Async
	public Future<List<T>> mapperAsync(List<S> souceList, T target) {
		List<T> list = asyncList(souceList, target);
		return new AsyncResult<>(list);
	}
	
	@SuppressWarnings({ "unchecked" })
	private T synchronousSingle(S source,T target) {
		target = (T) convert(source,target.getClass());
		return target;
	}
	
	@SuppressWarnings({ "unchecked" })
	private List<T> asyncList(List<S> souceList,T target) {
		List<T> list = (List<T>) convert(souceList, target.getClass());
		return list;
	}
	
}

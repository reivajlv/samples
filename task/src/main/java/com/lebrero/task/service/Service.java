package com.lebrero.task.service;

import java.util.Collection;


public interface Service<T> {
	
	public Collection<T> list();
	
	public Long create(T t);
	
	public T read(Long id);
	
	public void update(T t);
	
	public void delete(Long id);
	
}

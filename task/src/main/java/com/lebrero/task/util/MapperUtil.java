package com.lebrero.task.util;

import java.util.List;
import java.util.stream.Collectors;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil {
	
	
	private DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
		
	public <FROM, TO> List<TO> mapList(List<FROM> fromList, final Class<TO> toClass) {
	    return fromList
	            .stream()
	            .map(from -> this.dozerBeanMapper.map(from, toClass))
	            .collect(Collectors.toList());
	}	
	
	public <T, K> T map(K k, Class<T> t ) {
		T mappedObject = dozerBeanMapper.map(k, t);
		return mappedObject;
	}

}

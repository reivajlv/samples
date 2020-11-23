package com.lebrero.task.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaskLogger{
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	public void info(String msg) {
		log.info("[TASK PROJECT][INFO]", msg);
	}
	
	public void error(String msg) {
		log.error("[TASK PROJECT][ERROR]", msg);
	}
	
	public void debug(String msg) {
		log.debug("[TASK PROJECT][DEBUG]", msg);
	}
	
	public void warn(String msg) {
		log.warn("[TASK PROJECT][WARN]",msg);
	}

}

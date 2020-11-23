package com.lebrero.task.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lebrero.task.dto.TaskDTO;
import com.lebrero.task.service.Doable;
import com.lebrero.task.service.Service;

@RestController
@RequestMapping("/task")
public class TaskController {

	
	@Autowired
	private Service<TaskDTO> service;
	
	@Autowired
	private Doable doable;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TaskDTO read(@PathVariable("id") Long id) {
        return service.read(id);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TaskDTO> list() {
        return (List<TaskDTO>) service.list();
    }
      
    @RequestMapping(method = RequestMethod.POST)
    public Long create(@RequestBody TaskDTO task) {
    	return service.create(task);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody TaskDTO task) {
    	service.update(task);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
    	service.delete(id);
    }
    
    @RequestMapping(value = "/complete/{id}", method = RequestMethod.PUT)
    public void completeTask(@PathVariable("id") Long id) {
    	doable.complete(id);
    }
}

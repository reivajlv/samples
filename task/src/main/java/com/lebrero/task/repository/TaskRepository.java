package com.lebrero.task.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import com.lebrero.task.entity.Task;

@Service
public interface TaskRepository extends MongoRepository<Task, String>{

	  public Task findById(Long id);
	  public void deleteById(Long id);	  	  

}
package com.lebrero.task.service;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.lebrero.task.dto.TaskDTO;
import com.lebrero.task.entity.Task;
import com.lebrero.task.repository.TaskRepository;
import com.lebrero.task.util.MapperUtil;
import com.lebrero.task.util.TaskLogger;
import com.mongodb.MongoServerException;
import com.mongodb.MongoWriteException;

@org.springframework.stereotype.Service
public class TaskService implements Service<TaskDTO>, Doable{

	@Autowired
	private TaskLogger LOG;

	@Autowired
	private TaskRepository repository;

	@Autowired
	private MapperUtil mapperUtil;	

	@Override
	public List<TaskDTO> list() {

		List<Task> taskEntityList =  repository.findAll();

		List<TaskDTO> taskList = mapperUtil.mapList(taskEntityList, TaskDTO.class);

		return taskList;
	}

	@Override
	public Long create(TaskDTO t) {

		Long id=null;
		try {

			LOG.info("Creating the task with id: " + t.getId());
			Task taskEntity = mapperUtil.map(t, Task.class);

			id = repository.insert(taskEntity).getId();
		}catch(MongoWriteException e) {
			LOG.error("Error reading the task with id: " + id + "Error Message: " + e.getMessage());
		}

		return id;
	}

	@Override
	public TaskDTO read(Long id) {

		Task taskEntity = null;
		LOG.info("Reading the task with id: " + id);

		try {
			taskEntity = repository.findById(id);
		}catch(MongoServerException e) {
			LOG.error("Error reading the task with id: " + id + "Error Message: " + e.getMessage());
		}

		TaskDTO task = mapperUtil.map(taskEntity, TaskDTO.class);

		return task;

	}

	@Override
	public void update(TaskDTO t) {

		LOG.info("Saving the task with id: " + t.getId());

		Task taskEntity = mapperUtil.map(t, Task.class);

		try {
			repository.save(taskEntity);
		}catch(MongoServerException e) {
			LOG.error("Error updating the task with id: " + taskEntity.getId() + "Error Message: " + e.getMessage());
		}
	}

	@Override
	public void delete(Long id) {

		LOG.info("Deleting the task with id: " + id);
		try {
			repository.deleteById(id);
		}catch(MongoServerException e) {
			LOG.error("Error deleting the task with id: " + id + "Error Message: " + e.getMessage());
		}

	}

	@Override
	public void complete(Long id) {
		Task taskEntity = null;

		LOG.info("Completing the task with id: " + id);
		try {
			taskEntity = repository.findById(id);
		}catch(MongoServerException e) {
			LOG.error("Error deleting the task with id: " + id + "Error Message: " + e.getMessage());
		}

		taskEntity.setDone(true);

		LOG.info("Saving the task with id: " + id);
		try {
			repository.save(taskEntity);
		}catch(MongoServerException e) {
			LOG.error("Error updating the task with id: " + id + "Error Message: " + e.getMessage());
		}
	}

}

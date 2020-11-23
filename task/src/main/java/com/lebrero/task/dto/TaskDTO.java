package com.lebrero.task.dto;


public class TaskDTO {
	
	private Long id;
	private String title;
	private String description;
	private Integer priority;
	private String owner;
	private Boolean done;
	
	
	public TaskDTO() {
		
	}

	public TaskDTO(Long id, String title, String description, Integer priority, String owner, Boolean done) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.priority = priority;
		this.owner = owner;
		this.done = done;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Boolean getDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", priority=" + priority
				+ ", owner=" + owner + ", done=" + done + "]";
	}
	
	
	

}

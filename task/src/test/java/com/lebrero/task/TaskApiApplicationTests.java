package com.lebrero.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.lebrero.task.dto.TaskDTO;
import com.lebrero.task.entity.Task;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TaskApiApplicationTests {
	
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void create() throws Exception {
		assertThat(this.restTemplate.
				postForEntity("http://localhost:" + port + "/task/",new TaskDTO(10L, "Task1","Description1",1, "Me",false),Long.class))
				.isNotNull();
	}
	
	@Test
	public void read() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/task/1",TaskDTO.class)).isNotNull();
	}
	
	@Test
	public void update() throws Exception {
		this.restTemplate.put("http://localhost:" + port + "/task/",new TaskDTO(1L, "Task1","Description1",1, "You",false));
	}
	
	@Test
	public void complete() throws Exception {
		this.restTemplate.put("http://localhost:" + port + "/task/complete/1",new TaskDTO());
	}
	
	@Test
	public void delete() throws Exception {
		this.restTemplate.delete("http://localhost:" + port + "/task/1");
	}

}

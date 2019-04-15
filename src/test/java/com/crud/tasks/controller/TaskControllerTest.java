package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)

public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DbService dbService;

    @MockBean
    private TaskMapper taskMapper;

    @Test
    public void getTasks() throws Exception {
        //Given
        List<TaskDto> taskList = new ArrayList<>();
        taskList.add(new TaskDto());

        when(taskMapper.mapToTaskDtoList(dbService.getAllTask())).thenReturn(taskList);
        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)) // isOk()
                .andExpect(jsonPath("$", hasSize(1)));
    }


    @Test
    public void getTask() throws Exception {
        //When & Then
        mockMvc.perform(get("/v1/task/getTask").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)) // isOk()
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("test title")))
                .andExpect(jsonPath("$.content", is("test_content")));
    }


    @Test
    public void deleteTaskById() throws Exception {
        //When & Then
        mockMvc.perform(delete("/v1/task/deleteTaskById/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)); // isOk()
        dbService.deleteTaskById(1L);
        Mockito.verify(dbService, times(1)).deleteTaskById(1L);
    }

    @Test
    public void updateTask() throws Exception {
        //Given
        TaskDto taskToUpdate = new TaskDto(1L, "Udpdate", "Updating");
        TaskDto taskAfterUpdate = new TaskDto(1L, "Udpdate", "Updated");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(taskToUpdate);

        when(taskMapper.mapToTaskDto(dbService.saveTask(taskMapper.mapToTask(taskToUpdate)))).thenReturn(taskAfterUpdate);

        //When & Then
        mockMvc.perform(put("/v1/task/updateTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Udpdate")))
                .andExpect(jsonPath("$.content", is("Updated")));
    }

    @Test
    public void createTask() throws Exception {
        //Given
        TaskDto createdTask = new TaskDto(1L, "Create", "Create");
        Task savedTask = new Task(1L, "Save", "Saved");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(createdTask);

        when(dbService.saveTask(taskMapper.mapToTask(createdTask))).thenReturn(savedTask);

        //When & Then
        mockMvc.perform(post("/v1/task/createTask")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().is(200)); // isOk()

        Mockito.verify(dbService, times(1)).saveTask(taskMapper.mapToTask(createdTask));
    }

    @Test
    public void getTaskById() throws Exception {
        //Given
        Task foundThisTask = new Task(1L, "task", "found");

        when(dbService.findById(1L)).thenReturn(Optional.of(foundThisTask));

        //When & Then
        mockMvc.perform(get("/v1/task/getTaskById?id=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)); // isOk()
    }
}
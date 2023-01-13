package com.icolak.service.impl;

import com.icolak.dto.TaskDTO;
import com.icolak.entity.Task;
import com.icolak.mapper.TaskMapper;
import com.icolak.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {

    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskServiceImpl;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findByTaskId_Test(long id) {

        // Given (Preparation)
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));   // Optional<Task>
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        // When (Action is happening)
        taskServiceImpl.findByTaskId(id);// We are not defining this will be the method I want to test.

        // Then (Assertion and verification checks)
        verify(taskRepository).findById(id);
        verify(taskMapper).convertToDto(task);

    }

    @Test
    void findByTaskId_BDD_Test() {

        Task task = new Task();

        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        // When
        taskServiceImpl.findByTaskId(anyLong());

        // Then
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);
    }

}





















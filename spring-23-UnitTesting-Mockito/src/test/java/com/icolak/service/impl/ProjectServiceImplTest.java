package com.icolak.service.impl;

import com.icolak.dto.ProjectDTO;
import com.icolak.entity.Project;
import com.icolak.mapper.ProjectMapper;
import com.icolak.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void findByProjectCode_test() {

        // Given
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); // Stubbing
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO()); // Stubbing

        // When
        ProjectDTO projectDTO = projectService.findByProjectCode(anyString());

        // Then
        InOrder inOrder = inOrder(projectRepository, projectMapper); // want to check the order of these 2 Mocks
        inOrder.verify(projectRepository).findByProjectCode(anyString()); // providing in which order
        inOrder.verify(projectMapper).convertToDto(any(Project.class));  // these 2 Mock should be

        assertNotNull(projectDTO);
    }

    @Test
    void findByProjectCode_ExceptionTest() {

        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));
        Throwable throwable = assertThrows(NoSuchElementException.class, () -> projectService.findByProjectCode(""));

        verify(projectRepository).findByProjectCode("");

        verify(projectMapper, never()).convertToDto(any(Project.class));

        assertEquals("Project Not Found", throwable.getMessage());
    }

}
package com.icolak.service.impl;

import com.icolak.mapper.UserMapper;
import com.icolak.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // enabling mockito
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @InjectMocks // This annotation not able to work with interfaces, it works with directly the impl
    UserServiceImpl userService;

    @Test
    void findByUserName_Test() {

        // Calling the real method inside the main, which is the method wanted to be tested
        userService.findByUserName("harold@manager.com");
        // Checking if this method ran  or not.
        verify(userRepository).findByUserName("harold@manager.com");
        // Checking if this method is being called 1 times or not
        verify(userRepository, times(1)).findByUserName("harold@manager.com");

        verify(userRepository, atLeastOnce()).findByUserName("harold@manager.com");
        verify(userRepository, atLeast(1)).findByUserName("harold@manager.com");

        verify(userRepository, atMostOnce()).findByUserName("harold@manager.com");
        verify(userRepository, atMost(1)).findByUserName("harold@manager.com");

        InOrder inOrder = inOrder(userRepository, userMapper);

        inOrder.verify(userRepository).findByUserName("harold@manager.com"); // it works first
        inOrder.verify(userMapper).convertToDto(null);                // it works after so the test passes
    }

}
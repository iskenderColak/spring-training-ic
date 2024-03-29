package com.icolak.service;

import com.icolak.dto.UserDTO;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();

    UserDTO create(UserDTO userDTO);

}

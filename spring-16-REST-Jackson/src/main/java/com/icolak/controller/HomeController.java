package com.icolak.controller;

import com.icolak.dto.AccountDTO;
import com.icolak.dto.UserDTO;
import com.icolak.service.AccountService;
import com.icolak.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomeController {

    private final UserService userService;
    private final AccountService accountService;

    public HomeController(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<UserDTO> readAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/accounts")
    public List<AccountDTO> readAllAccounts() {
        return accountService.getAllAccounts();
    }
}

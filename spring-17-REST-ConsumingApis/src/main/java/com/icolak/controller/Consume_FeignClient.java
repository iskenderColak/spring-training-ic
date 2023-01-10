package com.icolak.controller;

import com.icolak.client.EmployeeClient;
import com.icolak.client.UserClient;
import com.icolak.dto.EmployeeDTO;
import com.icolak.dto.ResponseWrapper;
import com.icolak.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;
    private final EmployeeService employeeService;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient, EmployeeService employeeService) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
        this.employeeService = employeeService;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers() {
        return ResponseEntity.ok( new ResponseWrapper("User List Retrieved", userClient.getUsers()));
    }

    @GetMapping("/data/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee() {
        return ResponseEntity.ok( new ResponseWrapper("Employee Retrieved", employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
        return ResponseEntity.noContent().build();
    }
}

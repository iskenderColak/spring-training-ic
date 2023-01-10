package com.icolak.service.impl;

import com.icolak.dto.EmployeeDTO;
import com.icolak.entity.Employee;
import com.icolak.repository.EmployeeRepository;
import com.icolak.service.EmployeeService;
import com.icolak.util.MapperUtil;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final MapperUtil mapperUtil;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, MapperUtil mapperUtil) {
        this.employeeRepository = employeeRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public void save(EmployeeDTO employeeDTO) {
        employeeRepository.save(mapperUtil.convert(employeeDTO, new Employee()));
    }
}

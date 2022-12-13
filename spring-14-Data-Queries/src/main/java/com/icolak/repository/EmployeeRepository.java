package com.icolak.repository;

import com.icolak.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //Display all employees with email address ""
    Employee findByEmail(String email);

    //Display all employees with firstname "" and last name "",
    //also show all employees with an email address ""
    Employee findByFirstNameAndLastNameOrEmail(String fName, String lName, String email);

    //Display all employees that first name is not ""
    List<Employee> findAllByFirstNameIsNot(String fName);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartsWith(String pattern);

    //Display all employees with salaries higher&&less than ""
    List<Employee> findAllBySalaryGreaterThan(Integer Salary);
    List<Employee> findAllBySalaryLessThan(Integer Salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findAllByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greater and equal to "" in order-salary
    List<Employee> findAllBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findAllByEmailIsNull();

}
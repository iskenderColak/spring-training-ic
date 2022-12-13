package com.icolak.repository;

import com.icolak.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

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

    @Query("SELECT e FROM Employee e")
    List<Employee> retrieveEmployeeDetail();

    @Query("SELECT e.salary FROM Employee e")
    List<Integer> retrieveEmployeeSalaries();

    //Not Equal
    @Query("SELECT e FROM Employee e WHERE e.salary <> ?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);

    //Like / Contains / Starts-with / Ends-with
    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less Than
    @Query("SELECT e FROM Employee e WHERE e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //Greater Than
    @Query("SELECT e.firstName FROM Employee e WHERE e.salary > ?1")
    List<String> retrieveEmployeeSalaryGreaterThan(int salary);

    //BETWEEN
    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //BEFORE
    @Query("SELECT e FROM Employee e WHERE e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NULL")
    List<Employee> retrieveEmployeeEmailIsNull();

    //NOT NULL
    @Query("SELECT e FROM Employee e WHERE e.email IS NOT NULL")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //SORTING in Asc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary ASC")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //SORTING in Desc Order
    @Query("SELECT e FROM Employee e ORDER BY e.salary DESC ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();

    //Native Query
    @Query(value = "SELECT * FROM employees WHERE salary = ?1", nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);

    //Named Parameter
    @Query("SELECT e FROM Employee e WHERE e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);
}
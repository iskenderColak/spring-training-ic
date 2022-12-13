package com.icolak.repository;

import com.icolak.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department,String> {

    //Display all departments in the Furniture Department
    List<Department> findAllByDepartment(String Department);

    //Display all departments in the Health Division
    List<Department> findAllByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //Display all departments with division name ends with 'ics'
    List<Department> findAllByDivisionEndsWith(String pattern);

    //Display top 3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContains(String pattern);

}




/*

    @Query("SELECT d FROM Department d WHERE d.division IN ?1")
    List<Department> retrieveDepartmentDivision(List<String> division);
*/

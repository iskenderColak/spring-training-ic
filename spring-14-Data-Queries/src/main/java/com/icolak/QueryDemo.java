package com.icolak;

import com.icolak.repository.DepartmentRepository;
import com.icolak.repository.EmployeeRepository;
import com.icolak.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------REGIONS-----------");
        System.out.println("findByCountry: " + regionRepository.findAllByCountry("Canada"));
        System.out.println("findByCountryContaining:" + regionRepository.findAllByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegion:" + regionRepository.findAllByCountryContainingOrderByRegionDesc("United"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("-----------DEPARTMENTS----------");
        System.out.println("findByDepartment:" + departmentRepository.findAllByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findAllByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findAllByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByDivisionContains:" + departmentRepository.findDistinctTop3ByDivisionContains("Hea"));


    }
}

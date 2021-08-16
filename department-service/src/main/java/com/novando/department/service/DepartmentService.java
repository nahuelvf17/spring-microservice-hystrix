package com.novando.department.service;

import com.novando.department.entity.Department;
import com.novando.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDepartment(Department department) {
        log.info("inside save department method department service");
        return departmentRepository.save(department);

    }

    public Department findDepartmentById(Long departmentId) {
        log.info("inside save department method department service");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}

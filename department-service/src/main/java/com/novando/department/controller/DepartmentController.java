package com.novando.department.controller;

import com.novando.department.dto.DepartmentDto;
import com.novando.department.entity.Department;
import com.novando.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public ResponseEntity<?> saveDepartment(@RequestBody DepartmentDto departmentDto){
        log.info(departmentDto.toString());

        ModelMapper modelMapper = new ModelMapper();
        Department department = modelMapper.map(departmentDto, Department.class);

        log.info("inside save department method department controller");
        log.info(department.toString());
        return ResponseEntity.ok().body(departmentService.saveDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findDepartmentById(@PathVariable("id") Long departmentId){
        log.info("Inside find department method department controller");
        return ResponseEntity.ok(departmentService.findDepartmentById(departmentId));

    }
}

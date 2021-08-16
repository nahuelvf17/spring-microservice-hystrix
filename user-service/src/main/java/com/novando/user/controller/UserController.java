package com.novando.user.controller;

import com.novando.user.VO.ResponseTemplateVO;
import com.novando.user.dto.UserDto;
import com.novando.user.entity.User;
import com.novando.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto){
        log.info(userDto.toString());

        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDto, User.class);

        log.info("inside save department method user controller");
        log.info(user.toString());
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("inside save getUserWithDepartment method user controller");

        return userService.UserWithDepartment(userId);
    }
}

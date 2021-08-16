package com.novando.user.service;

import com.novando.user.VO.Department;
import com.novando.user.VO.ResponseTemplateVO;
import com.novando.user.entity.User;
import com.novando.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO UserWithDepartment(Long userId) {
        log.info("Inside saveUser of UserWithDepartment");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getUserId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}

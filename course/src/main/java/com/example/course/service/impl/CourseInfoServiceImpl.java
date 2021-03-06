package com.example.course.service.impl;

import com.example.course.model.Course;
import com.example.course.model.UserCourse;
import com.example.course.service.CourseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CourseInfoServiceImpl implements CourseInfoService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Course> getUserCourses(Long userId) {

//        RestTemplate restTemplate = new RestTemplate();
        UserCourse userCourses = restTemplate.getForObject("http://course-information/course/info" + userId, UserCourse.class);
        return userCourses.getCourses();
    }

}

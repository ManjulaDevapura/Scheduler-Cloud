package com.manjuladev.schedulercloud.schedulerservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SchedulerServiceImple implements SchedulerService {

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Project saveProject(Project project) {
        String url = "http://localhost:8770/services/project";
        Project respProj = restTemplate.postForObject(url, project, Project.class);
        return respProj;
    }

//
//    @Override
//    public List<Project> getProject() {
//        return null;
//    }
//
//    @Override
//    public Project getProjectByCode() {
//        return null;
//    }
//
//    @Override
//    public Project updateProject(Project project) {
//        return null;
//    }
//
//    @Override
//    public Project deleteProject(int code) {
//        return null;
//    }
}

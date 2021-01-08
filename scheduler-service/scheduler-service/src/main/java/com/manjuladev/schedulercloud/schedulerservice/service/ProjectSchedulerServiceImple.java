package com.manjuladev.schedulercloud.schedulerservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProjectSchedulerServiceImple implements ProjectSchedulerService {
    private String url = "http://localhost:8770/services/project";

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public Project saveProject(Project project) {
        Project respProj = restTemplate.postForObject(url, project, Project.class);
        return respProj;
    }

    @Override
    public List<Project> getProject() {
        ResponseEntity<Project[]> responseEntity = restTemplate.getForEntity(url+"s", Project[].class);
        List<Project> respProj = Arrays.asList(responseEntity.getBody());
        return respProj;
    }

    @Override
    public Project getProjectByCode(int code) {
        Project respProj = restTemplate.getForObject(url+"/"+code, Project.class);
        return respProj;
    }

    @Override
    public Project updateProject(Project project) {
        Project respProj = restTemplate.patchForObject(url, project, Project.class);
        return respProj;
    }

    @Override
    public Project deleteProject(int code) {
        Project respProj = restTemplate.getForObject(url+"/"+code, Project.class);
        return respProj;
    }
}

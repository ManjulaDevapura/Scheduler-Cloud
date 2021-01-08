package com.manjuladev.schedulercloud.schedulerservice.service;

import com.manjuladev.schedulercloud.commons.model.project.Project;
import com.manjuladev.schedulercloud.commons.model.request.Filter;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskDetailResponse;
import com.manjuladev.schedulercloud.commons.model.response.ProjectTaskResponse;
import com.manjuladev.schedulercloud.commons.model.task.Task;
import com.manjuladev.schedulercloud.schedulerservice.component.CustomizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class SchedulerServiceImple implements SchedulerService {
    private final String url = "http://localhost:8770/services/project";

    @Bean
    RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    RestTemplate restTemplate;


    @Override
    public ProjectTaskDetailResponse getProjectWithTasks(int code) throws Exception {
        Filter filter = new Filter();
        filter.setFilterType("project");
        filter.setFilterId(code);

        Project project = getProjectByCode(code);
        List<Task> task = getTasksByProjectRef(code);

        if (project == null) throw new CustomizedException("NOT_FOUND", "Error from here", "404");
        return new ProjectTaskDetailResponse(project, task);
    }

    private Project getProjectByCode(int code) {
        Project respProj = restTemplate.getForObject("http://localhost:8770/services/project/" + code, Project.class);
        return respProj;
    }

    private List<Task> getTasksByProjectRef(int projectRef) {
        Filter filter = new Filter();
        filter.setFilterType("project");
        filter.setFilterId(projectRef);
        ResponseEntity<Task[]> responseEntity = restTemplate.postForEntity("http://localhost:8780/services/taskFiltered", filter, Task[].class);
        List<Task> respTask = Arrays.asList(responseEntity.getBody());

        return respTask;
    }

    void checker() throws CustomizedException {
        throw new CustomizedException("404", "Error from here", "Null");
    }


//    private Task getTasksByProjectRef2(Filter filter) {
//        Task respTask = restTemplate.getForObject("http://localhost:8780/services/taskFiltered", filter, Task.class);
//        return respTask;
//    }

//    @Override
//    public Project saveProject(Project project) {
//        Project respProj = restTemplate.postForObject(url, project, Project.class);
//        return respProj;
//    }
//
//    @Override
//    public List<Project> getProject() {
//        ResponseEntity<Project[]> responseEntity = restTemplate.getForEntity(url+"s", Project[].class);
//        List<Project> respProj = Arrays.asList(responseEntity.getBody());
//        return respProj;
//    }
//

//
//    @Override
//    public Project updateProject(Project project) {
//        Project respProj = restTemplate.patchForObject(url, project, Project.class);
//        return respProj;
//    }
//
//    @Override
//    public Project deleteProject(int code) {
//        Project respProj = restTemplate.getForObject(url+"/"+code, Project.class);
//        return respProj;
//    }


}

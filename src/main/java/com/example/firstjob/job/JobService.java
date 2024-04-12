package com.example.firstjob.job;

import java.util.List;

public interface JobService {

    List<Job> findALl();

    void create(Job job);


    Job getJobById(Long id);


    Boolean deleteJob(Long id);

    Boolean updateJob(Long id, Job UpdateJob);
}

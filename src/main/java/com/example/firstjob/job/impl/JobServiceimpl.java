package com.example.firstjob.job.impl;

import com.example.firstjob.job.Job;
import com.example.firstjob.job.JobRepositiry;
import com.example.firstjob.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceimpl implements JobService {

//    private List<Job> jobs = new ArrayList<>();

    JobRepositiry jobRepositiry;

    public JobServiceimpl(JobRepositiry jobRepositiry) {
        this.jobRepositiry = jobRepositiry;
    }


    private  long Nxtid = 1L;
    @Override
    public List<Job> findALl() {
        return jobRepositiry.findAll();
    }

    @Override
    public void create(Job job) {
        job.setId(Nxtid++);
        jobRepositiry.save(job);
    }

    @Override
    public Job getJobById(Long id) {

        return jobRepositiry.findById(id).orElse(null);


    }

    @Override
    public Boolean deleteJob(Long id) {

        try {
            jobRepositiry.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public Boolean updateJob(Long id, Job UpdateJob) {

        Optional<Job> jobOptional = jobRepositiry.findById(id);

            if (jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setTitle(UpdateJob.getTitle());
                job.setDescription(UpdateJob.getDescription());
                job.setMinSalery(UpdateJob.getMinSalery());
                job.setMaxSalery(UpdateJob.getMaxSalery());
                job.setLocation(UpdateJob.getLocation());
                jobRepositiry.save(job);
                return true;
            }

        return null;

    }


}

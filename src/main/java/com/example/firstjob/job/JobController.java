package com.example.firstjob.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getJob(){

        return new ResponseEntity<>(jobService.findALl(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> postJob(@RequestBody Job job){
        jobService.create(job);

        return new  ResponseEntity<>("Successfully",HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job job = jobService.getJobById(id);

        if(job != null){
            return new  ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id){

        Boolean deleted = jobService.deleteJob(id);

        if (deleted){
            return "Yessssss";
        }
        return "NOO";
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Long id,@RequestBody Job updateJob){

        Boolean update = jobService.updateJob(id,updateJob);

        if (update){
            return "Update";
        }
        return "Not update";

    }

}

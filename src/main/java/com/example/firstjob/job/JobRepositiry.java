package com.example.firstjob.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;

public interface JobRepositiry extends JpaRepository<Job, Long> {



}

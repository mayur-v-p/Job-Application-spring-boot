package com.example.firstjob.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepositery  extends JpaRepository<Review,Long> {
    List<Review> findByCompanyId(Long companyId);
}

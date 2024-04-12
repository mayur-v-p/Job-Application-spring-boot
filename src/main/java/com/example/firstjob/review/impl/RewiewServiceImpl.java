package com.example.firstjob.review.impl;

import com.example.firstjob.company.Company;
import com.example.firstjob.company.CompanyService;
import com.example.firstjob.review.Review;
import com.example.firstjob.review.ReviewRepositery;
import com.example.firstjob.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RewiewServiceImpl implements ReviewService {

    private ReviewRepositery reviewRepositery;
    private CompanyService companyService;

    public RewiewServiceImpl(ReviewRepositery reviewRepositery, CompanyService companyService) {
        this.reviewRepositery = reviewRepositery;
        this.companyService = companyService;
    }


    @Override
    public List<Review> getAllReviews(Long companyId) {

        List<Review> reviews = reviewRepositery.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.companyById(companyId);
        if (company != null) {

            review.setCompany(company);
            reviewRepositery.save(review);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Optional<Review> getReviewByID(Long companyId, Long reviewId) {

        Company company = companyService.companyById(companyId);
        if (company!=null){
            Optional<Review> review = reviewRepositery.findById(reviewId);
            if (review!=null){
                return review;
            }
        }

        return null;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if (companyService.companyById(companyId)!=null){
            updatedReview.setCompany(companyService.companyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepositery.save(updatedReview);

            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {

        if (companyService.companyById(companyId)!=null){
            reviewRepositery.deleteById(reviewId);
            return true;
        }else {
            return false;
        }
    }
}

package com.example.firstjob.review;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("companies/{companyId}")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public List<Review> getAllReviews(@PathVariable Long companyId){
        return reviewService.getAllReviews(companyId);
    }

    @PostMapping("/reviews")
    public String addReview(@PathVariable Long companyId ,@RequestBody Review review){
        boolean yes =  reviewService.addReview(companyId, review);

        if (yes){
            return "review added";
        }else {
            return "review not added";
        }

    }

    @GetMapping("/reviews/{reviewId}")
    public Optional<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        return reviewService.getReviewByID(companyId,reviewId);
    }

    @PutMapping("/reviews/{reviewId}")
    public String updateReview(@PathVariable Long companyId,@PathVariable Long reviewId, @RequestBody Review review){
          boolean yes =  reviewService.updateReview(companyId,reviewId,review);

          if (yes) {
              return "Update successful";
          }else {
              return "Not updated";
          }
    }

    @DeleteMapping("/reviews/{reviewId}")
    public String deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean yes = reviewService.deleteReview(companyId,reviewId);
        if (yes) {
            return "delete successful";
        }else {
            return "Not deleted";
        }
    }




}

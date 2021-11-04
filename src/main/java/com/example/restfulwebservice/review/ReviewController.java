package com.example.restfulwebservice.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private BlogReviewService service;

    @GetMapping("/blog")
    public List<BlogReview> searchBlogReview(
            @RequestParam(value="keyword", defaultValue = "서초 문화 축제")
                    String keyword){

        return service.searchBlogReview(keyword);
    }
}

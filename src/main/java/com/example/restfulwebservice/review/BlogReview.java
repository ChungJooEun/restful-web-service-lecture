package com.example.restfulwebservice.review;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogReview {

    private Integer id;

    private String blogName;
    private String writeDate;
    private String title;
    private String imgUrl;
    private String link;
}

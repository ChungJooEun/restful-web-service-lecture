package com.example.restfulwebservice.review;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BlogReviewService {

    public List<BlogReview> searchBlogReview (String keyword){

        return parseHtml(getHtml(keyword));
    }

    // 사용자가 입력한 keyword 중, 띄어쓰기가 있으면 + 로 바꿔줌
    private String replaceSpace(String keyword){
        return keyword.replaceAll(" ","+");
    }

    // html 문서를 크롤링함
    private Document getHtml(String keyword){
        String connectUrl = "https://search.naver.com/search.naver?where=blog&query="+replaceSpace(keyword);

        try{
            Document doc = Jsoup.connect(connectUrl).get();
            return doc;
        }catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    private List<BlogReview> parseHtml(Document doc){

        List<BlogReview> reviews = new ArrayList<BlogReview>();

        Elements list = doc.select(".api_subject_bx ul li");
        int id = 1;
        for(Element item : list){
            reviews.add(convertToEntity(item, id++));
        }

        return reviews;
    }

    private BlogReview convertToEntity(Element item, int id){

        String blogName = item.select(".elss.etc_dsc_inner a").html().toString();
        String writeDate = item.select(".sub_time.sub_txt").html();
        String title = item.select(".total_area > a").html();
        String link = item.select(".total_area > a").attr("href");
        String imgUrl = item.select(".total_wrap.api_ani_send > a > span > img").attr("src");

        return new BlogReview(id, blogName, writeDate, title, imgUrl, link);
    }
}

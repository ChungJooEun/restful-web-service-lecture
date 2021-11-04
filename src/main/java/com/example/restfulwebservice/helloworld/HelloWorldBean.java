package com.example.restfulwebservice.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   //모든 필드의 생성자, getter, setter
@AllArgsConstructor
public class HelloWorldBean {

    private String message;

}

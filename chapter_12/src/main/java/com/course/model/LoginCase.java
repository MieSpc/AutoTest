package com.course.model;

import lombok.Data;

@Data
public class LoginCase {
    private String user_name;
    private String password;
    private String expected;
}

package com.course.model;

import lombok.Data;

@Data
public class UpdateUserInfoCase {

    private int user_id;
    private String user_name;
    private int sex;
    private int age;
    private int permission;
    private int is_deleted;
    private String expected;
}

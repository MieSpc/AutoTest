package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {

    private String user_name;
    private String password;
    private int sex;
    private int age;
    private int permission;
    private int is_deleted;
    private String expected;
}

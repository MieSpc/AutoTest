package com.course.model;

import lombok.Data;

@Data
public class GetUserListCase {

    private String user_name;
    private int sex;
    private int age;
    private String expected;

}

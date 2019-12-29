package com.course.modul;

import lombok.Data;

@Data
public class User {
    private int id;
    private String user_name;
    private String password;
    private int sex;
    private int age;
    private String phone_number;
    private int permission;
    private int is_deleted;
}

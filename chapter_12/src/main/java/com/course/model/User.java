package com.course.model;

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

    @Override
    public String toString(){
        return ("{id:"+id+","+
                "userName:"+user_name+","+
                "password:"+password+","+
                "age:"+age+","+
                "sex:"+sex+","+
                "phone_number:"+phone_number+","+
                "permission:"+permission+","+
                "is_deleted:"+is_deleted+"}");
    }
}

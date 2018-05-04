package com.exercise.exercise.filter;

import org.mindrot.jbcrypt.BCrypt;

import java.util.Date;

/**
 * @author Solomon
 * @date 2018/5/5
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(BCrypt.checkpw("12345","$2a$10$rdp5NOxUdP0n7KSwdaI41OA1UX9gRCkBdV1XQJ6g/WmCPd99Pmeci"));
        System.out.println(System.currentTimeMillis());
    }
}

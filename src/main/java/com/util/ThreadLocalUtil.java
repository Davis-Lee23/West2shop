package com.util;

import com.entity.User;

/**
 * @Description: TODO
 * @author: LZP
 * @date: 2022年08月25日 10:27
 */
public class ThreadLocalUtil {

    private ThreadLocalUtil(){}

    private static final ThreadLocal<User> LOCAL = new ThreadLocal<>();

    public static void put(User user){
        LOCAL.set(user);
    }
    public static User get(){
        return LOCAL.get();
    }
    public static void remove(){
        LOCAL.remove();
    }
}

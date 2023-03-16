package com.logixtek.training.todoapp.utils;

import java.util.UUID;

public class GlobalUtils {

    public static String generateId() {
        return UUID.randomUUID().toString().substring(24);
    }

}

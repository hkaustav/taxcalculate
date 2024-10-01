package com.kc.acitiviti.taxcalculate;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserStore {

    Map<String, String> users = new HashMap<String, String>();

    public UserStore() {
        users.put("kc", "p1");
        users.put("sp", "p2");
        users.put("mc", "p3");
    }

    public String get(String username) {
        return users.get(username);
    }
}

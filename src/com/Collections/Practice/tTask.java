package com.Collections.Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class tTask {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(Map.of("Marty", "Step",
                                                            "Stuart", "Reges",
                                                                "Jessica", "Stepp",
                                                                        "Amanda", "Camp",
                                                                    "Hal", "Perkins"));
        System.out.println(check(map));
    }

    public static boolean check(Map<String, String>map){
        HashSet<String> set = new HashSet<>(map.values());
        return set.size() == map.size();
    }
}

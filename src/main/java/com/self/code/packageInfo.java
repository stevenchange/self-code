package com.self.code;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program: self-code
 * @description: package information
 * @author: GaoBo
 * @create: 2019/10/12
 **/
public class packageInfo {

    public static void main(String[] args) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("1", null);
        map.put("2", "");
        for(Map.Entry<String, Object> entry : map.entrySet()){
            System.out.println(entry.getKey());
        }
    }

}

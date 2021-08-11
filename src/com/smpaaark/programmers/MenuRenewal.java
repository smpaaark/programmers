package com.smpaaark.programmers;

import java.util.*;

public class MenuRenewal {

    public static void main(String[] args) {
        MenuRenewal q = new MenuRenewal();
        q.solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5});
    }

    public String[] solution(String[] orders, int[] course) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        Map<Integer, Integer> courseMaxMap = new HashMap<>();
        for (String order : orders) {
            char[] orderArray = order.toCharArray();
            Arrays.sort(orderArray);
            solution2(orderArray, course, map, courseMaxMap);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 2) {
                if (entry.getValue() == courseMaxMap.get(entry.getKey().length())) {
                    list.add(entry.getKey());
                }
            }
        }

        String[] result = list.stream().toArray(String[]::new);
        Arrays.sort(result);

        return result;
    }

    private void solution2(char[] order, int[] course, LinkedHashMap<String, Integer> map, Map<Integer, Integer> courseMaxMap) {
        for (int length : course) {
            if (length > order.length) {
                return;
            }

            solution3(order, length, map, 0, "", courseMaxMap);
        }
    }

    private void solution3(char[] order, int length, LinkedHashMap<String, Integer> map, int index, String temp, Map<Integer, Integer> courseMaxMap) {
        if (temp.length() == length) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            courseMaxMap.put(length, Math.max(courseMaxMap.getOrDefault(length, 0), map.get(temp)));

            return;
        }

        for (int i = index; i < order.length; i++) {
            solution3(order, length, map, i + 1, temp + order[i], courseMaxMap);
        }
    }

}

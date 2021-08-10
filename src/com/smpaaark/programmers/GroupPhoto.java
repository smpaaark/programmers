package com.smpaaark.programmers;

import java.util.HashMap;
import java.util.Map;

public class GroupPhoto {

    private int result = 0;

    public static void main(String[] args) {
        GroupPhoto q = new GroupPhoto();
        System.out.println(q.solution(2, new String[] {"N~F=0", "R~T>2"}));
    }

    public int solution(int n, String[] data) {
        Map<Character, Integer> map = new HashMap<>();
        char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        recursion(map, data, friends, 0);

        return result;
    }

    private void recursion(Map<Character, Integer> map, String[] data, char[] friends, int index) {
        if (index == friends.length) {
            if (validate(map, data)) {
                result++;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (!map.containsKey(friends[i])) {
                map.put(friends[i], index);
                recursion(map, data, friends, index + 1);
                map.remove(friends[i]);
            }
        }
    }

    private boolean validate(Map<Character, Integer> map, String[] data) {
        for (String limit : data) {
            int index1 = map.get(limit.charAt(0));
            int index2 = map.get(limit.charAt(2));
            char operation = limit.charAt(3);
            int limitDistance = Integer.parseInt(String.valueOf(limit.charAt(4))) + 1;
            int distance = Math.abs(index2 - index1);
            if (operation == '=' && distance != limitDistance) {
                return false;
            } else if (operation == '>' && distance <= limitDistance) {
                return false;
            } else if (operation == '<' && distance >= limitDistance) {
                return false;
            }
        }

        return true;
    }

}

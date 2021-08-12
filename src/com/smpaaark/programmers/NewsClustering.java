package com.smpaaark.programmers;

import java.util.*;

public class NewsClustering {

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        settingList(list1, str1);
        settingList(list2, str2);

        if (list1.size() == 0 && list2.size() == 0) {
            return 65536;
        } else if (list1.size() == 0) {
            return 0;
        } else if (list2.size() == 0) {
            return 65536;
        }

        Map<String, Integer> commonMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for (String str : list1) {
            int count = commonMap.getOrDefault(str, 0) + 1;
            commonMap.put(str, count);
            sumMap.put(str, count);
        }

        int commonCount = 0;
        for (String str : list2) {
            if (commonMap.containsKey(str) && commonMap.get(str) > 0) {
                commonCount++;
                commonMap.put(str, commonMap.get(str) - 1);
            }
        }

        int sumCount = list1.size();
        for (String str : list2) {
            if (sumMap.containsKey(str) && sumMap.get(str) > 0) {
                sumMap.put(str, sumMap.get(str) - 1);
            } else {
                sumCount++;
            }
        }

        return (int)(((double)commonCount / (double)sumCount) * 65536);
    }

    private void settingList(List<String> list, String str) {
        String word = "";
        for (char c : str.toCharArray()) {
            int intC = c;
            if (intC >= 'a' && intC <= 'z') {
                word += c;
            } else {
                word = "";
            }

            if (word.length() == 2) {
                list.add(word);
                word = c + "";
            }
        }
    }

}

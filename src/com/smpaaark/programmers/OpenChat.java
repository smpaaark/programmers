package com.smpaaark.programmers;

import java.util.HashMap;
import java.util.Map;

public class OpenChat {

    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int resultSize = 0;
        for (String message : record) {
            String[] messageArray = message.split(" ");
            String action = messageArray[0];
            if ("Enter".equals(action) || "Change".equals(action)) {
                map.put(messageArray[1], messageArray[2]);
            }

            if ("Enter".equals(action) || "Leave".equals(action)) {
                resultSize++;
            }
        }

        String[] result = new String[resultSize];
        int resultIndex = 0;
        for (String message: record) {
            String[] messageArray = message.split(" ");
            String action = messageArray[0];
            if ("Enter".equals(action)) {
                result[resultIndex++] = map.get(messageArray[1]) + "님이 들어왔습니다.";
            } else if ("Leave".equals(action)) {
                result[resultIndex++] = map.get(messageArray[1]) + "님이 나갔습니다.";
            }
        }

        return result;
    }

}

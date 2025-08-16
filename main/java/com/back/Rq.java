package com.back;

import java.util.HashMap;
import java.util.Map;

public class Rq {

    private Map<String, String> paramMap;
    private String actionName;

    public Rq(String command) {
        paramMap = new HashMap<>();

        String[] commandBits = command.split("\\?");

        actionName = commandBits[0];
        String queryString = "";

        if (commandBits.length > 1) {
            queryString = commandBits[1];
        }

        String[] queryStringBits = queryString.split("&");
        for (String param : queryStringBits) {
            String[] paramBits = param.split("=");
            String key = paramBits[0];
            String value = null;

            if (paramBits.length < 2) {
                continue;
            }

            value = paramBits[1];

            paramMap.put(key, value);
        }
    }

    public String getActionName() {
        return actionName;
    }

    public String getParam(String key){
            return paramMap.get(key);
    }

    public int getParamAsInt(String key, int defaultValue) {

        String value = getParam(key);

        if(value == null){
            return defaultValue;
        }

        return Integer.parseInt(value);
    }
}

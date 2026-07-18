package org.acs.cprs.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExtJSReturn {

    private ExtJSReturn() {
    }

    public static Map<String, Object> mapOK(List<?> records) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("total", records.size());
        modelMap.put("data", records);
        modelMap.put("success", true);
        return modelMap;
    }

    public static Map<String, Object> mapOK(List<?> records, long total) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("total", total);
        modelMap.put("data", records);
        modelMap.put("success", true);
        return modelMap;
    }

    public static Map<String, Object> mapError(String msg) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("message", msg);
        modelMap.put("success", false);
        return modelMap;
    }
}

package org.acs.cprs.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tools.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class I18nMessageController {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping(value = "/i18n.action", produces = "application/x-javascript;charset=UTF-8")
    public void i18n(HttpServletResponse response, Locale locale) throws IOException {
        response.setContentType("application/x-javascript;charset=UTF-8");
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);

        Map<String, String> messages = new HashMap<>();
        Enumeration<String> keys = bundle.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            messages.put(key, bundle.getString(key));
        }

        String output = "var i18n = " + objectMapper.writeValueAsString(messages) + ";";
        response.getOutputStream().write(output.getBytes(StandardCharsets.UTF_8));
    }
}

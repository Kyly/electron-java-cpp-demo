package com.spark.endpoint;

import com.fasterxml.jackson.databind.JsonNode;
import com.spark.service.NativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/calculate")
public class Calculate {

    private final NativeService nativeService;

    @Autowired
    public Calculate(NativeService nativeService) {
        this.nativeService = nativeService;
    }

    @GetMapping(value = "/{name}")
    public Map<String, JsonNode> calculate(@PathVariable("name") String name) {

        Map<String, JsonNode> greeting = new HashMap<>();
        greeting.put("result", nativeService.getGreeting(name));

        return greeting;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greeting")
    public Map<String, JsonNode> greeting(String name) throws Exception {

        Map<String, JsonNode> greeting = new HashMap<>();
        greeting.put("result", nativeService.getGreeting(name));

        return greeting;
    }
}

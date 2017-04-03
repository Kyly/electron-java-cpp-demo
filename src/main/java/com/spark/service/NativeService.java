package com.spark.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.spark.helloNative.HelloWorldLibrary;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class NativeService {

    private ObjectMapper mapper;

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
    }

    public JsonNode getGreeting(String name) {

        final PointerByReference ptrRef = new PointerByReference();
        HelloWorldLibrary.INSTANCE.helloWorld(name, ptrRef);
        Pointer ptr = ptrRef.getValue();
        String cstring = ptr.getString(0);
        HelloWorldLibrary.INSTANCE.cleanUp(ptr);
        ObjectNode greetingObject = mapper.createObjectNode();
        greetingObject.put("greeting", cstring);

        return greetingObject;

    }
}

package com.example.demo.controller;

import com.example.demo.service.EmotionService;
import com.example.demo.model.EmotionResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class EmotionController {

    private final EmotionService service;

    public EmotionController(EmotionService service) {
        this.service = service;
    }

    @PostMapping("/analyze")
    public EmotionResponse analyze(@RequestBody Map<String, String> body) {
        return service.analyze(body.get("text"));
    }
}
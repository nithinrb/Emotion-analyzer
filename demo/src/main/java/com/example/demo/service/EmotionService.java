package com.example.demo.service;

import com.example.demo.model.EmotionResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmotionService {

    public EmotionResponse analyze(String text) {

        String[] sentences = text.split("[.!?]");
        Map<String, Double> emotions = new HashMap<>();

        for (String sentence : sentences) {
            String t = sentence.toLowerCase();

            // JOY
            if (t.contains("happy") || t.contains("love") || t.contains("great") || t.contains("excited") || t.contains("amazing")) {
                emotions.put("joy", emotions.getOrDefault("joy", 0.0) + 30);
            }

            // ANGER
            if (t.contains("hate") || t.contains("angry") || t.contains("frustrated") || t.contains("annoyed")) {
                emotions.put("anger", emotions.getOrDefault("anger", 0.0) + 30);
            }

            // SADNESS
            if (t.contains("sad") || t.contains("cry") || t.contains("depressed") || t.contains("disappointed") || t.contains("lonely")) {
                emotions.put("sadness", emotions.getOrDefault("sadness", 0.0) + 30);
            }

            // FEAR
            if (t.contains("scared") || t.contains("afraid") || t.contains("nervous") || t.contains("worried")) {
                emotions.put("fear", emotions.getOrDefault("fear", 0.0) + 30);
            }

            // SARCASM
            if (t.contains("oh great") || t.contains("yeah right") || t.contains("just perfect")) {
                emotions.put("sarcasm", emotions.getOrDefault("sarcasm", 0.0) + 40);
            }
        }

        // fallback
        if (emotions.isEmpty()) {
            emotions.put("neutral", 50.0);
            emotions.put("uncertain", 50.0);
        }

        // find dominant
        String dominant = emotions.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        EmotionResponse res = new EmotionResponse();
        res.setText(text);
        res.setEmotions(emotions);
        res.setExplanation("Dominant emotion: " + dominant + " (keyword-based analysis)");

        return res;
    }
}
package com.example.demo.model;

import java.util.Map;

public class EmotionResponse {

    private String text;
    private Map<String, Double> emotions;
    private String explanation;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, Double> getEmotions() {
        return emotions;
    }

    public void setEmotions(Map<String, Double> emotions) {
        this.emotions = emotions;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
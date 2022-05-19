package com.example.myapplication.model;

import java.util.List;

public class Car {
    private String name;
    private int image;
    private Answer answer;


    public Car(String name, int image, Answer answer) {
        this.name = name;
        this.image = image;
        this.answer = answer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

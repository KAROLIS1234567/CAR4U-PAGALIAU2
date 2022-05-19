package com.example.myapplication.model;

import java.util.List;

public class Answer {
    private String budget;
    private String[] age;
    private  String UsedForDriving;
    private String size;
    private String driverWheels;
    private String questionPriority;
    private String questionAdvantage;


    public Answer(String budget, String[] age, String usedForDriving, String size, String driverWheels, String questionPriority, String questionAdvantage) {
        this.budget = budget;
        this.age = age;
        UsedForDriving = usedForDriving;
        this.size = size;
        this.driverWheels = driverWheels;
        this.questionPriority = questionPriority;
        this.questionAdvantage = questionAdvantage;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String[] getAge() {
        return age;
    }

    public void setAge(String[] age) {
        this.age = age;
    }

    public String getUsedForDriving() {
        return UsedForDriving;
    }

    public void setUsedForDriving(String usedForDriving) {
        UsedForDriving = usedForDriving;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDriverWheels() {
        return driverWheels;
    }

    public void setDriverWheels(String driverWheels) {
        this.driverWheels = driverWheels;
    }

    public String getQuestionPriority() {
        return questionPriority;
    }

    public void setQuestionPriority(String questionPriority) {
        this.questionPriority = questionPriority;
    }

    public String getQuestionAdvantage() {
        return questionAdvantage;
    }

    public void setQuestionAdvantage(String questionAdvantage) {
        this.questionAdvantage = questionAdvantage;
    }
}

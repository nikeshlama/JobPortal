package com.nikesh.jobportal.Model;

import java.util.List;

public class Job {
    String title;
    String price;
    String id;
    String description;
    List<String> requirement;
    String date;
    String userId;

    public Job(String title, String price, String id, String description, List<String> requirement, String date, String userId) {
        this.title = title;
        this.price = price;
        this.id = id;
        this.description = description;
        this.requirement = requirement;
        this.date = date;
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getRequirement() {
        return requirement;
    }

    public void setRequirement(List<String> requirement) {
        this.requirement = requirement;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Job() {
    }
}

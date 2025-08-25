package com.noqok.a90plus_quiz.models;

public class User {
    private String userId;
    private String username;
    private String email;
    private int highScore;

    // Constructors
    public User() {
    }

    public User(String userId, String username, String email, int highScore) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.highScore = highScore;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }
}

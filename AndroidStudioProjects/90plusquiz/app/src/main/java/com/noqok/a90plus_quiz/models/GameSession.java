package com.noqok.a90plus_quiz.models;

import java.util.List;

public class GameSession {
    private String sessionId;
    private String userId;
    private String gameMode;
    private int score;
    private int currentQuestionIndex;
    private List<Question> questions;

    // Constructors
    public GameSession() {
    }

    public GameSession(String sessionId, String userId, String gameMode, int score, int currentQuestionIndex, List<Question> questions) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.gameMode = gameMode;
        this.score = score;
        this.currentQuestionIndex = currentQuestionIndex;
        this.questions = questions;
    }

    // Getters and Setters
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }



    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}

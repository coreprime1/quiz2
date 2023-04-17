package com.dreamyards.topquiz2.model;

import java.util.List;

public class Question {

    private String mQuestion;
    private List<String> mChoixPossible;
    private int mBonneReponse;

    public Question(String question, List<String> choixPossible, int bonneReponse) {
        mQuestion = question;
        mChoixPossible = choixPossible;
        mBonneReponse = bonneReponse;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoixPossible() {
        return mChoixPossible;
    }

    public void setChoixPossible(List<String> choixPossible) {
        mChoixPossible = choixPossible;
    }

    public int getBonneReponse() {
        return mBonneReponse;
    }

    public void setBonneReponse(int bonneReponse) {
        mBonneReponse = bonneReponse;
    }
}

package com.dreamyards.topquiz2.model;

public class User {
    private String sName;
    private int mScore = 0;


    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public void incrementScore(){
        mScore++;
    }

    public void decrementScore(){
        if(mScore > 0 )
            mScore--;
    }
}
package com.example.geoquiz;

import android.util.Log;

public class Question {
    private int mTextResid;
    private  boolean mAnswer;
    private static final String TAG = "Question";

    public Question(int TextResid, boolean Answer) {
        Log.d(TAG, " конструктор класса Question");
        mTextResid = TextResid;
        mAnswer = Answer;
    }

    public int getTextResid() {
        return mTextResid;
    }

    public void setTextResid(int textResid) {
        mTextResid = textResid;
    }

    public boolean isAnsver() {
        return mAnswer;
    }

    public void setAnsver(boolean ansver) {
        mAnswer = ansver;
    }
}

package com.example.user.quizapp;

/**
 * Created by user on 2016-11-26.
 */

public class Question {
    public String que;
    public String que_num;
    public String option1;
    public String option2;
    public String option3;
    public String option4;
    public String rightanswer;

    public Question(String que_num,String que, String option1, String option2, String option3, String option4, String rightanswer) {
        this.que = que;
        this.que_num = que_num;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightanswer=rightanswer;
    }

    public String getQue() {
        return que;
    }

    public String getQue_num() {
        return que_num;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getRightanswer() {
        return rightanswer;
    }
}

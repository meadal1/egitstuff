package com.example.aaron.endangeredbirds;

/**
 * Created by aaron on 21-Nov-18.
 */

public class Question {
    private String question; //question
    private String answer1; //first answer
    private String answer2; //second answer
    private String answer3; //third answer
    private String answer4; //fourth answer
    private String correctAnswer; //correct answer
    public Question(String q, String a1, String a2, String a3, String a4, String c) {
        setQuestion(q);
        setAnswer1(a1);
        setAnswer2(a2);
        setAnswer3(a3);
        setAnswer4(a4);
        setCorrectAnswer(c);
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}

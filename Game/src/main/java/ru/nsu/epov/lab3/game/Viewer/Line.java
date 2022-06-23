package ru.nsu.epov.lab3.game.Viewer;

public class Line {

    private String nickName;
    private int score;


    public Line(String nickName, int score)
    {
        this.nickName = nickName;
        this.score = score;
    }

    public String getNickName(){ return nickName;}

    public int getScore(){ return score;}



}

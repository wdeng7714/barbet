package com.example.angelachang.wagify;

import java.util.List;

/**
 * Created by wendydeng on 9/16/17.
 */

public class FriendlyWager {
    private Double mAmount;
    private String mDate, mTask, mName;
    private List<String> mParticipants;

    public FriendlyWager(Double amount, String date, String task, String name, List<String> participants){
        mAmount = amount;
        mDate = date;
        mTask = task;
        mName = name;
        mParticipants = participants;
    }

    public Double getAmount(){
        return mAmount;
    }
    public String getDate(){
        return mDate;
    }
    public String getTask(){
        return mTask;
    }
    public String getmName(){
        return mName;
    }
    public List<String> getmParticipants() {
        return mParticipants;
    }
}

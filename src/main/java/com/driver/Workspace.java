package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId,Integer.MAX_VALUE);
        calendar= new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am
        int max=0;

        if(calendar.size()>0) {
            Collections.sort(calendar, Comparator.comparing(Meeting::getEndTime));

            LocalTime past = LocalTime.MIN;
            for (Meeting m : calendar){
                if(m.getStartTime().compareTo(past) >= 0){

                    max++;
                    past=m.getEndTime();
//                    System.out.println(m.getStartTime()+" "+m.getEndTime()+" "+past+" "+m.getEndTime().compareTo(past));

                }
            }

        }
        return max;


    }
}

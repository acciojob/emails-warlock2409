package com.driver;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
    }
    ArrayList<mail> newMail = new ArrayList<>();
    ArrayList<mail> trash = new ArrayList<>();

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.
        if(newMail.size() < inboxCapacity){
            newMail.add(new mail(date,sender,message));
//            System.out.println("mail received"+newMail.size());

        }else{
            trash.add(newMail.get(0));
            newMail.remove(0);
            newMail.add(new mail(date, sender, message));
//            System.out.println("mail is full");
        }
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        for(int i=0;i<newMail.size();i++){
            if(newMail.get(i).getMessage().equals(message)){
                trash.add(newMail.remove(i));
//                System.out.println("mail removed");
                break;
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(newMail.size()>0){
            return newMail.get(newMail.size()-1).getMessage();
        }
        return null;

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(newMail.size()>0){
            return newMail.get(0).getMessage();
        }
        return null;

    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int mailCount=0;
        for (mail e : newMail){
            Date receivedDate = e.getDate();
            if(receivedDate.compareTo(start) >= 0 && receivedDate.compareTo(end) <=0){
                mailCount++;
            }
        }
        return mailCount;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return newMail.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;

    }
}

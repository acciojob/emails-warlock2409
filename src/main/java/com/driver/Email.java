package com.driver;

import java.util.regex.Pattern;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:
        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter
        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
            if(!oldPassword.equals(this.password)){
//                System.out.println("Password not match");

                return;
            }
            if(oldPassword.length()<8){
//                System.out.println("less than 8");

                return;
            }
            if(!Pattern.compile("[A-Z]").matcher(newPassword).find()){
//                System.out.println("uppercase missing");

                return;
            }
            if(!Pattern.compile("[a-z]").matcher(newPassword).find()){
//                System.out.println("lowercase missing");

                return;
            }
             if(!Pattern.compile("[0-9]").matcher(newPassword).find()){
//                 System.out.println("Number missing");

            return;
            }
            if(!Pattern.compile("[^a-zA-Z0-9]").matcher(newPassword).find()){
//                System.out.println("special character missing");

                return;
            }
            this.password = newPassword;
//            System.out.println("Password Changed Successfully");





    }
}

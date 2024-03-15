package com.task2_parkinglot;





import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;


public class UserAuthenticationSystem {
    private List<User> users;

    public UserAuthenticationSystem() {
        this.users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }
    public UserAuthenticationSystem getUserAuthenticationSystem(){
        return new UserAuthenticationSystem();
    }

    public void signUp(String userName, String password) {
        if (checkPasswordFormat(password)) {
            User newUser = new User(userName, password);
            users.add(newUser);
            System.out.println("User "+userName+" has been created successfully");

        } else {
            System.out.println("Invalid password format");
            throw new InputMismatchException("Input Mismatch");
        }
    }

    public void signIn(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                System.out.println(" Log in successful");
            }
        }
        System.out.println("Invalid username or password");

    }


    public static boolean checkPasswordFormat(String str) {
        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        for(int i=0;i < str.length();i++) {
            ch = str.charAt(i);
            if( Character.isDigit(ch)) {
                numberFlag = true;
            }
            else if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } else if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            }
            if(numberFlag && capitalFlag && lowerCaseFlag)
                return true;
        }
        return false;
    }

}


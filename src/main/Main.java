package main;

import javax.swing.*;

import data.User;
import page.Login;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class Main {
	// Declare the user data ArrayList
    public static ArrayList<User> userDataList = userDataList = new ArrayList<>();;
    public Main() {
    	
        
        // Add some dummy user data to the ArrayList
        userDataList.add(new User("natasha", "nat123"));
        userDataList.add(new User("michelle", "chel123"));
        userDataList.add(new User("felix", "lix123"));
        new Login();
    }
    
	public static void main(String[] args) {
		new Main();
    }
}


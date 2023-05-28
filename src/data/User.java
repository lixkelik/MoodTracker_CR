package data;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private String username;
    private String password;

    private ArrayList<Mood> moodDataList = new ArrayList<>();

    private static User currentUser;

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void insertMood(Mood m) {
        moodDataList.add(m);
    }

    public static void setCurrentUser(User u) {
        currentUser = u;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public ArrayList<Mood> getMoodDataList() {
        return new ArrayList<>(moodDataList);
    }
}


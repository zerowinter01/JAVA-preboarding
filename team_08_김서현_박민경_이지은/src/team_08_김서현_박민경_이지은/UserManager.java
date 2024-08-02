package team_08_김서현_박민경_이지은;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class UserManager {
    private List<User> users = new ArrayList<>();
    private User loggedInUser; 
    private final String USER_FILE = "data/user.json"; 

    public UserManager() {
        loadUsers(); 
    }

 
    public boolean signUp(String userId, String password, String nickName, String username, String phonenumber) {
        
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return false; 
            }
        }

        User newUser = new User();
        newUser.setUserId(userId);
        newUser.setPassword(password);
        newUser.setNickName(nickName);
        newUser.setUsername(username);
        newUser.setPhonenumber(phonenumber);
        users.add(newUser);
        saveUsers();
        return true; 
    }

  
    public User login(String userId, String password) {
        for (User user : users) {
            if (user.getUserId().equals(userId) && user.getPassword().equals(password)) {
                loggedInUser = user; 
                return user;
            }
        }
        return null; 
    }

 
    public void logout() {
        loggedInUser = null; 
    }


    public String findPassword(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return "Password: " + user.getPassword(); 
            }
        }
        return "User not found"; 
    }


    public User getLoggedInUser() {
        return loggedInUser;
    }


    private void loadUsers() {
        Gson gson = new Gson();
        Type userListType = new TypeToken<List<User>>() {}.getType();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(USER_FILE)))) {
            users = gson.fromJson(br, userListType);
            if (users == null) {
                users = new ArrayList<>();
            }
        } catch (FileNotFoundException e) {
            users = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveUsers() {
        Gson gson = new Gson();
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(USER_FILE)))) {
            gson.toJson(users, bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

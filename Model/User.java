package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User implements Serializable {
    public static User toShowUser=null;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    public byte [] n ;
    public static int likeNum = 0 ;
    public Set<String> followings = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getN() {
        return n;
    }

    public void setN(byte[] n) {
        this.n = n;
    }

    public boolean follow(String username){
        if(followings.contains(username))
            return false;
        followings.add(username);
        return true;
    }

    public int getFollower(){
        return followings.size();
    }
    public boolean unfollow(String username){
        if(followings.contains(username)) {
            followings.remove(username);
            return true;
        }
        return false;
    }
}

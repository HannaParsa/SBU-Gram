package Server;

import Model.Comment;
import Model.Post;
import Model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//API
public class Repository {
    public static List<User> userList = new ArrayList<>();
    public static List<Post> posts = new ArrayList<>();
    public static Set<String> followers = new HashSet<>();
    public static Set<String> following = new HashSet<>();
    public static List<String> likes = new ArrayList<>();
    public static List<Comment> comments = new ArrayList<>();
    public static boolean checker(String username, String password){
        for(User user : userList){
            if (user.getUsername().equals(username) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
    public static boolean checkSignup (String username){
        for(User user : userList){
            if ((user.getUsername().contains(username)))
                return false;
        }
        return true;
    }
    public static List<Post> findPost(String username){
        ArrayList<Post> output = new ArrayList<>();
        for(Post post:posts){
            if (post.getPublisher().equals(username)){
                output.add(post);
            }
        }
        return output;

    }
    public static Set<String>following(String username){
        HashSet<String> output = new HashSet<>();
        if (!(followers.contains(username))) {
            followers.add(username);
            output.add(username);

        }
        return output;
    }
    public static Set<String>unfollowing(String username){
        HashSet<String> output = new HashSet<>();
        if(followers.contains(username)){
            followers.remove(username);
            output.remove(username);
        }
        return output;
    }
    public static void likeCheck(String username){
        for(String l:likes){
            if(!(l.contains(username))){
                likes.add(username);
            }
        }
    }
    public static void deleteUser(User user){
        for(int i = 0 ; i < userList.size() ; i ++){
            User u = userList.get(i);
            if (u.getUsername().equals(user.getUsername())){
                userList.remove(i);
                break;
            }
        }
    }
    public static String finPass(String username){
        String output=null;
        for(User u:userList){
            if(u.getUsername().equals(username)){
                output=u.getPassword();
            }
        }
        return output;
    }
    public static boolean profileChecker(User user){
        for(User u:userList){
            if(u.getUsername().equals(user.getUsername()))
                return true;
        }
        return false;
    }

    public static User getUser(String username) {
        for (User user : userList){
            if (user.getUsername().equals(username))
                return user;
        }
        return null;
    }
    public static List<Post> allPost(String username) {
        ArrayList<Post> output = new ArrayList<>();
        for (Post post : posts) {
            output.add(post);
        }
        return output;
    }
    public static List<User> allUser(String username) {
        ArrayList<User> output = new ArrayList<>();
        for (User users : userList) {
            output.add(users);
        }
        return output;
    }
    public static String finUsername(String username){
        String output=null;
        for(User u:userList){
            if(u.getUsername().equals(username)){
                output=u.getUsername();
            }
        }
        return output;
    }

}

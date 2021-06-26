package Server;
import Controller.signupController;
import Model.Comment;
import Model.Post;
import Model.User;

import javax.print.attribute.HashAttributeSet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.*;

import static Server.Repository.*;


public class Server implements Runnable{
    ServerSocket serverSocket;
    Socket socket;
    signupController signupController;

    public static void main(String[] args) {
        new Thread(new Server()).start();
    }

    @Override
    public void run() {
        {
            try {
                serverSocket = new ServerSocket(8888);
                socket = serverSocket.accept();
                new Thread(
                        ()->
                        {
                            try {
                                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

                                while(true){
                                    Map<String,Object> map = null;
                                    try {

                                        map = (Map<String , Object>) ois.readObject();
                                    } catch (IOException | ClassNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    Map<String,Object> answer = new HashMap<>();
                                    switch ((String)map.get("command")){
                                        case "login":
                                            String username = (String) map.get("username");
                                            String password = (String) map.get("password");
                                            boolean check = checker(username,password);
                                            if(check==true){

                                                System.out.println("action : login");
                                                System.out.println(username + " login");
                                                System.out.println("time: " + LocalDateTime.now());
                                            }

                                            answer.put("command","login");
                                            answer.put("answer",check);
                                            answer.put("profile", getUser(username));
                                            break;
                                        case "signup":
                                            User user = (User) map.get("user");
                                            boolean checkSignup= checkSignup(user.getUsername());
                                            if (checkSignup==true) {
                                                userList.add(user);
                                                answer.put("command", "signup");
                                                System.out.println(user.getUsername() + " registered");
                                                System.out.println("time: " + LocalDateTime.now());
                                            }
                                            answer.put("command","signup");
                                            answer.put("answer",checkSignup);
                                            answer.put("profile", getUser(user.getUsername()));
                                            break;
                                        case "addPost":
                                            Post post = (Post)map.get("post");
                                            posts.add(post);
                                            answer.put("answer",true);
                                            System.out.println(post.getPublisher()+" publish");
                                            System.out.println("time: "+LocalDateTime.now());
                                            break;
                                        case"postList":
                                            String Username = (String) map.get("username");
                                            System.out.println(Username+" get posts list");
                                            System.out.println("time: "+LocalDateTime.now());
                                            List<Post> posts = findPost(Username);
                                            answer.put("answer",posts);
                                            break;
                                        case"follow":
                                            String USERMAME = (String) map.get("username");
                                            System.out.println(USERMAME+" followed");
                                            System.out.println("time: "+ LocalDateTime.now());
                                            Set<String> followers = following(USERMAME);
                                            answer.put("answer",followers);
                                            break;
                                        case"unfollow":
                                            String uSERMAME = (String) map.get("username");
                                            System.out.println(uSERMAME+"unfollowed");
                                            System.out.println("time: "+ LocalDateTime.now());
                                            Set<String> Followers = unfollowing(uSERMAME);
                                            answer.put("answer",Followers);
                                            break;
                                        case"like":
                                            String usERNAME=(String) map.get("username");
                                            likeCheck(usERNAME);
                                            System.out.println(usERNAME+" liked");
                                            System.out.println("time: "+usERNAME);
                                            answer.put("answer",true);
                                            break;
                                        case"comment":
                                            Comment comment= (Comment)map.get("comment");
                                            comments.add(comment);
                                            answer.put("answer",true);
                                            System.out.println(comment.getSayer()+" commented");
                                            System.out.println("time: "+LocalDateTime.now());
                                            break;
                                        case"logout":
                                            String UsERMAME = (String) map.get("username");
                                            answer.put("answer",true);
                                            System.out.println(UsERMAME+" logout");
                                            System.out.println("time: "+LocalDateTime.now());
                                            break;
                                        case"delete account":
                                            User User = (User) map.get("user");
                                            System.out.println(User.getUsername() + " deleted account");
                                            System.out.println("time: " + LocalDateTime.now());
                                            deleteUser(User);
                                            answer.put("answer",true);
                                            break;
                                        case"findPass":
                                            String UseRNAME=(String) map.get("username");
                                            String pass= finPass(UseRNAME);
                                            System.out.println(UseRNAME+" find Password");
                                            System.out.println("time: "+LocalDateTime.now());
                                            answer.put("answer",pass);
                                            break;
                                        case"profile":
                                            User USer=(User) map.get("user");
                                            User output = Repository.getUser(USer.getUsername());
                                            System.out.println(USer.getUsername() + " checked profile");
                                            System.out.println("time: " + LocalDateTime.now());
                                            answer.put("answer",true);
                                            answer.put("profile",output);
                                            break;
                                        case"edit":
                                            User UsEr = (User) map.get("user");
                                            for(int i = 0; i < userList.size() ; i++){
                                                User u = userList.get(i);
                                                if (u.getUsername().equals(UsEr.getUsername())) {
                                                    userList.remove(i);
                                                    break;
                                                }
                                            }
                                            userList.add(UsEr);
                                            System.out.println(UsEr.getUsername() + " edited profile");
                                            System.out.println("time: " + LocalDateTime.now());
                                            answer.put("answer",true);
                                            break;
                                        case"repost":
                                            Post POST = (Post)map.get("post");
                                            Repository.posts.add(POST);
                                            answer.put("answer",true);
                                            System.out.println(POST.getPublisher()+" repost");
                                            System.out.println("time: "+LocalDateTime.now());
                                            break;
                                        case"allPost":
                                            String uSername = (String) map.get("username");
                                            System.out.println(uSername+" get all posts list");
                                            System.out.println("time: "+LocalDateTime.now());
                                            List<Post> allPosts = allPost(uSername);
                                            answer.put("answer",allPosts);
                                            break;
                                        case"allUsers":
                                            String uSeRname = (String) map.get("username");
                                            System.out.println(uSeRname+" go to userLists");
                                            System.out.println("time: "+LocalDateTime.now());
                                            List<User> allUsers=Repository.allUser(uSeRname);
                                            answer.put("answer",allUsers);
                                            break;
                                        case"findUser":
                                            String userName =  (String) map.get("username");
                                            String foundUsername=Repository.finUsername(userName);
                                            System.out.println(userName+" found another user");
                                            System.out.println("time: "+LocalDateTime.now());
                                            answer.put("answer",foundUsername);
                                            break;
                                    }
                                    try {
                                        oos.writeObject(answer);
                                        oos.flush();
                                    }catch (Exception e){
                                        e.printStackTrace();
                                    }

                                }}catch (Exception e){e.printStackTrace();}
                        }

                ).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



package Server;

import Model.Comment;
import Model.Main;
import Model.Post;
import Model.User;
import Server.Socket;

import java.io.IOException;
import java.util.*;

public class ServerHandler {
   public static boolean login(String username, String password) throws IOException, ClassNotFoundException {
      Map <String , Object> map = new HashMap<>();
      map.put("command", "login");
      map.put("username",username);
      map.put("password",password);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      Main.currentUser = (User) answer.get("profile");
      return (boolean) answer.get("answer");
   }
   public static boolean signIn(User user) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","signup");
      map.put("user",user );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      Main.currentUser = (User) answer.get("profile");
      return (boolean) answer.get("answer");

   }
   public static boolean addPost(Post post) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","addPost");
      map.put("post",post );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean) answer.get("answer");

   }
   public static List<Post> postList(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","postList");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (List<Post>) answer.get("answer");
   }
   public static Set<String> follow(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","follow");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (Set<String>)answer.get("answer");
   }
   public static Set<String>unfollow(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","unfollow");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (Set<String>)answer.get("answer");
   }
   public static boolean like(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","like");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean)answer.get("answer");
   }
   public static boolean comment(Comment comment) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","comment");
      map.put("comment",comment );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean) answer.get("answer");

   }
   public static boolean logout(String username) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","logout");
      map.put("username",username );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean) answer.get("answer");

   }
   public static boolean deleteAccount(User user) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","delete account");
      map.put("user",user );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean) answer.get("answer");

   }
   public static String findPass(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","findPass");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (String)answer.get("answer");
   }
   public static boolean findProfile(User user)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","profile");
      map.put("user",user);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      User.toShowUser = (User) answer.get("profile");
      return (boolean)answer.get("answer");
   }
   public static boolean editProfile(User user) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","edit");
      map.put("user",user );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean) answer.get("answer");

   }
   public static boolean repost(Post post) throws IOException, ClassNotFoundException {
      Map<String , Object> map = new HashMap<>();
      map.put("command","repost");
      map.put("post",post );
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (boolean) answer.get("answer");

   }
   public static List<Post> allPosts(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","allPost");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (List<Post>) answer.get("answer");
   }
   public static List<User> allUsers(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","allUsers");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (List<User>) answer.get("answer");
   }
   public static String findUser(String username)throws IOException, ClassNotFoundException{
      Map<String , Object> map = new HashMap<>();
      map.put("command","findUser");
      map.put("username",username);
      Socket.outputStream.reset();
      Socket.outputStream.writeObject(map);
      Socket.outputStream.flush();
      Map<String,Object> answer = (Map<String, Object>) Socket.inputStream.readObject();
      return (String)answer.get("answer");
   }

}

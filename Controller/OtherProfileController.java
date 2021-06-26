package Controller;

import Model.Main;
import Model.PageLoader;
import Model.User;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class OtherProfileController {

    public ImageView image;
    public Label numFollowing;//
    public Label numFollower;
    public Label username;
    User user = User.toShowUser;
    public void initialize() throws IOException, ClassNotFoundException ,NullPointerException, InvocationTargetException {
        //aks kar nemikone baghi doroste
        username.setText(Main.currentUsername);
        numFollower.setText(User.toShowUser.getFollower()+"");
        if(User.toShowUser.getN() != null)
            image.setImage(new Image(new ByteArrayInputStream(User.toShowUser.getN())));
        ServerHandler.findProfile(user);
    }

    public void follow(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        //hame User.toShowPost ==Main currentUser. alan doroste follow/unfollow ina avaz nakon
        if (Main.currentUser.follow(Main.currentUsername)) {
            numFollower.setText(Main.currentUser.getFollower()+"");
        }else {
            System.out.println("followed before");
        }
        ServerHandler.follow(Main.currentUsername);
    }

    public void unfollow(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if(Main.currentUser.unfollow(Main.currentUsername)){
            numFollower.setText(Main.currentUser.getFollower()+"");
        }
        else{
            System.out.println("unfollowed before");
        }
        ServerHandler.unfollow(Main.currentUsername);
    }


    public void goToTimeLine(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }

    public void goMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("menu");
    }
}

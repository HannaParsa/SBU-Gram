package Controller;

import Model.Main;
import Model.PageLoader;
import Model.Post;
import Model.User;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ProfileController {

    public ImageView profileImage;
    public Label numFollowers;
    public Label numFollowings;//
    public Label firstName;
    public Label lastName;
    public Label phoneNumber;//
    User user = Main.currentUser;

    public void initialize() throws IOException, ClassNotFoundException {
        ServerHandler.findProfile(user);
        firstName.setText(Main.currentUsername);
        //lastName.setText(User.toShowUser.getLastName());
        //numFollowers.setText(Integer.toString(User.toShowUser.getFollower()));
        if(User.toShowUser.getN() != null) {
            profileImage.setImage(new Image(new ByteArrayInputStream(User.toShowUser.getN())));
        }
    }

    public void edit(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("edit");
    }

    public void deleteAccount(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setUsername(Main.currentUsername);
        ServerHandler.deleteAccount(user);
        new PageLoader().load("sample");
    }

    public void backMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("menu");
    }

    public void goPostListUsername(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        new PageLoader().load("timeLine");
    }
}

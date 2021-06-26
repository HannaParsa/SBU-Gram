package Controller;

import Model.PageLoader;
import Model.Post;
import Model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
//mesle postItemController bara user ha

public class UserItemController {
    public Label username;
    public AnchorPane root;
    User user = new User();

    public UserItemController(User user) throws IOException {
        new PageLoader().load("userItem", this);
        this.user=user;
    }
    public AnchorPane init() {
        username.setText(user.getUsername());
        return root;
    }


    public void goToProfile(ActionEvent actionEvent) throws IOException,NullPointerException, InvocationTargetException {
        new PageLoader().load("otherProfile");
    }
}

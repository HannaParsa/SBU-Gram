package Controller;

import Model.Main;
import Model.PageLoader;
import Model.User;
import Server.ServerHandler;
import javafx.event.ActionEvent;

import java.io.IOException;

public class MenuController {
    User user = new User();

    public void goTimeLine(ActionEvent actionEvent) throws IOException {
        //post haye khode username to timeline
        new PageLoader().load("timeLine");
    }

    public void goToProfile(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("profile");

    }

    public void doToDirects(ActionEvent actionEvent) {
        //ehtemalan ba serevr bezanam
        //emtiazi
    }

    public void addPost(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("addPost");
    }

    public void logOut(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        ServerHandler.logout(user.getUsername());
        new PageLoader().load("sample");
    }

    public void gotimeline(ActionEvent actionEvent) throws IOException{
        //all posts
        new PageLoader().load("allPosts");
    }

    public void goAttendance(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("people");
    }
}

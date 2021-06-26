package Controller;

import Model.Main;
import Model.PageLoader;
import Model.Post;
import Model.User;
import Server.ServerHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

//mesle timeline bara user ha faghat
public class People {
    public ListView<User> listView;
    public TextField Username;
    public Label f_username;
    ArrayList<User> users = new ArrayList<>();
    public static User toShowUser = null;
    public String username;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        users = (ArrayList<User>) ServerHandler.allUsers(Main.currentUsername);
        listView.setItems(FXCollections.observableArrayList(users));
        listView.setCellFactory( listView -> new UserItem());
    }

    public void showUser(MouseEvent mouseEvent) throws NullPointerException, IOException, ClassNotFoundException {
        User u = new User();

        u.setUsername(listView.getSelectionModel().getSelectedItem().getUsername());
    }

    public void goTimeLine(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("allPosts");
    }

    public void serch(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        username = Username.getText();
        String password = ServerHandler.findUser(username);
        f_username.setText(password);
    }
}


package Controller;

import Model.PageLoader;
import Model.User;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static Server.Repository.userList;

public class FindPassController {

    public Button findPass;
    public Label foundPassword;
    public TextField fist_name;
    public TextField user_name;
    public String Username;

    public void initialize() {
    }

    public void goLoginPage(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("sample");
    }

    public void findMyPassword(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        Username = user_name.getText();
        String password = ServerHandler.findPass(Username);
        foundPassword.setText(password);

    }
}

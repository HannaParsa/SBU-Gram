package Controller;


import Model.PageLoader;
import Server.ServerHandler;
import com.sun.javafx.collections.MappingChange;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Controller {
    @FXML
    public TextField username_field;
    public PasswordField password_field;
    public Label wrong_label;
    public Button login_button;
    public TextField password_visible;
    public Button signup_buttom;
    public Pane wrong_labl;
    public Label empty_pass_user;

    @FXML
    public void initialize() {
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(5000), login_button);
        translateTransition.setByY(-80);
        translateTransition.playFromStart();
    }

    public void login(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String Username = username_field.getText();
        String Password;
        if (password_field.isVisible() == true)
            Password = password_field.getText();
        else
            Password = password_visible.getText();
        if (Password.length() == 0 || Username.length() == 0) {
            empty_pass_user.setVisible(true);
        } else {
            wrong_label.setVisible(true);
        }

        if (ServerHandler.login(Username,Password)==true)
        {
            new PageLoader().load("menu");
        }
        else {
            wrong_label.setVisible(true);
        }



    }

    public void show_pass(ActionEvent actionEvent) {
        if (password_visible.isVisible() == false) {
            password_visible.setVisible(true);
            password_field.setVisible(false);
            password_visible.setText(password_field.getText());
        } else {
            password_visible.setVisible(false);
            password_field.setVisible(true);
            password_field.setText(password_visible.getText());
        }
    }

    public void signup(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("signup");
    }
}

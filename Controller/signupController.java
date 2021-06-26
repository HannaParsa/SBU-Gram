package Controller;

import Model.Main;
import Model.PageLoader;
import Model.User;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Popup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class signupController {

    public TextField firstname_field;
    public TextField lastname_field;
    public TextField number_field;
    public TextField password_field;
    public TextField username_field;
    public Label invalid_password;
    public Label invalid_username;
    public Label notFilled;
    public Button signup_buttom;
    public Button lastpage_buttom;
    public Button choosePic_button;
    public ImageView image_profile;
    List<String> nameList;
    User user = new User();

    public void signup(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String FirstName = firstname_field.getText();
        String LastName = lastname_field.getText();
        String Password = password_field.getText();
        String Username = username_field.getText();
        nameList = new ArrayList<>();
        String Number = number_field.getText();

        if(Username == null || Password == null || Username.length() == 0 || Password.length() == 0)
            notFilled.setVisible(true);
        else {

            user.setUsername(Username);
            user.setPassword(Password);
            if (ServerHandler.signIn(user)==false) {
                invalid_username.setVisible(true);
            }

            else {
                invalid_username.setVisible(false);

                if (Password.matches("[a-zA-Z0-9]{8,}")){

                    Main.currentUsername = username_field.getText();
                    Main.currentPublisher = firstname_field.getText();

                    invalid_password.setVisible(false);
                    new PageLoader().load("menu");
                }
                else {
                    invalid_password.setVisible(true);
                }
            }

        }
    }

    public void goLastPage(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("sample");
    }

    public void choosPic(ActionEvent actionEvent) throws IOException{
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Popup());
        FileInputStream fileInputStream = new FileInputStream(file);
        user.n = fileInputStream.readAllBytes();
        Image image = new Image(new ByteArrayInputStream(user.n));
        image_profile.setImage(image);
        user.setN(fileInputStream.readAllBytes());
    }

    public void findPassword(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("findPass");
    }
}

package Controller;

import Model.Main;
import Model.PageLoader;
import Model.User;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Popup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EditController {
    public TextField username;
    public TextField password;
    public ImageView IMAGE;
    public TextField firstName;
    public TextField lastName;
    public TextField number;
    User user = new User();
    public void choosePic(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Popup());
        FileInputStream fileInputStream = new FileInputStream(file);
        user.n = fileInputStream.readAllBytes();
        Image image = new Image(new ByteArrayInputStream(user.n));
        IMAGE.setImage(image);
        user.setN(fileInputStream.readAllBytes());
    }

    public void edit(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        String Password = user.getPassword();
        String Username = user.getUsername();
//        if( username.getText().length() != 0 ) {
//            user.setUsername(Username);
//            Main.currentUsername = username.getText();
//            Main.currentPublisher = username.getText();
//        }
        if(password.getText().length()!=0 ) {
            user.setPassword(Password);

        }
        ServerHandler.editProfile(user);
    }

    public void backmenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("menu");
    }
}

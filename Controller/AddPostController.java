package Controller;

import Model.Main;
import Model.PageLoader;
import Model.Post;
import Model.User;
import Server.Repository;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Popup;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AddPostController {


    public TextArea text_field;
    public TextField titel_field;
    public Post post = new Post();
    public ImageView image;

    public void publish(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        //post.setImage(image.getImage());
        post.setTitle(titel_field.getText());
        post.setDescription(text_field.getText());
        post.setWriter(Main.currentUsername);
        post.setPublisher(Main.currentUsername);

        //Repository.posts.add(post);
        ServerHandler.addPost(post);
        System.out.println("your post published");
    }

    public void backToPosts(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }

    public void refresh(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
        System.out.println("page has refreshed");
    }

    public void choosePicture(ActionEvent actionEvent) throws IOException {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(new Popup());
        FileInputStream fileInputStream = new FileInputStream(file);
        post.p = fileInputStream.readAllBytes();
        Image imagee = new Image(new ByteArrayInputStream(post.p));
        image.setImage(imagee);
//        post.setP(fileInputStream.readAllBytes());
    }
}

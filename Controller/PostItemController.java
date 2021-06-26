package Controller;

import Model.PageLoader;
import Model.Post;
import Model.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Time;

public class PostItemController {
    public AnchorPane root;
    public ImageView profileImage;
    public Label username;
    public Label title;
    public Label writer;
    Post post;
    User user = new User();

    public PostItemController(Post post) throws IOException {
        new PageLoader().load("postItem", this);
        this.post = post;
    }

    public AnchorPane init() {
        username.setText(post.getPublisher());
        title.setText(post.getTitle());
        writer.setText(post.getWriter());
        return root;
    }

    public void details(ActionEvent actionEvent) throws IOException {
        System.out.println(post.getTitle() + " Clicked");
        TimeLine.toShowPost = post;
        new PageLoader().load("showPostPage");
    }
    public void goProfile(ActionEvent actionEvent)throws IOException{
        User.toShowUser=user;
        new PageLoader().load("otherProfile");
    }
    public void like (ActionEvent actionEvent){
        user.likeNum ++;
    }
}
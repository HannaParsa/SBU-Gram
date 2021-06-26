package Controller;

import Model.Comment;
import Model.Main;
import Model.PageLoader;
import Model.Post;
import Server.Repository;
import Server.ServerHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class showPostPageController {
    public static Post toShowCommentPost;

    public Label writter;
    @FXML
    private Label title;

    @FXML
    private Label desc;

    @FXML
    private ImageView image;

    @FXML
    private Label likes;

    @FXML
    private Label reposts;

    @FXML
    private Label publisher;

    public void initialize(){
        writter.setText(TimeLine.toShowPost.getWriter());
        title.setText(TimeLine.toShowPost.getTitle());
        desc.setText(TimeLine.toShowPost.getDescription());
        publisher.setText("@"+TimeLine.toShowPost.getPublisher());
        likes.setText(TimeLine.toShowPost.getLikes()+"");
        image.setImage(new Image(new ByteArrayInputStream(TimeLine.toShowPost.getP())));

    }

    @FXML
    void comment(ActionEvent event) throws IOException, ClassNotFoundException  {
        Comment comment = new Comment();
        ServerHandler.comment(comment);
        new PageLoader().load("commentPage");
    }

    @FXML
    void like(ActionEvent event) throws IOException, ClassNotFoundException {
        if (TimeLine.toShowPost.like(Main.currentUsername)) {
            likes.setText(TimeLine.toShowPost.getLikes()+"");
        }else {
            System.out.println("Liked before");
        }
        ServerHandler.like(Main.currentUsername);
    }

    @FXML
    void repost(ActionEvent event) throws IOException, ClassNotFoundException {
        if (TimeLine.toShowPost.reposts(Main.currentPublisher)) {
            reposts.setText(TimeLine.toShowPost.getReposts() + "");
            Post post = new Post();
            post.setTitle(title.getText());
            post.setDescription(desc.getText());
            post.setWriter(Main.currentUsername);
            post.setPublisher(Main.currentPublisher);
            //Repository.posts.add(post);
            ServerHandler.repost(post);
        }
        else{
            System.out.println("you have already repost it");
        }

    }
    public void backMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");

    }

    public void refresh(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }
}

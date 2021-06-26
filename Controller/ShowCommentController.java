package Controller;

import Model.Comment;
import Model.Main;
import Model.PageLoader;
import Model.Post;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class ShowCommentController {
    public TextArea description;
    public TextField title;
    @FXML
    private ListView<Comment> commentList;
    public static Comment toShowComment = null;
    private ArrayList<Comment> comments = new ArrayList<>();

    @FXML
    public void initialize() {
        //description.setText(TimeLine.toShowPost.getDescription());
        //for (int i = 1; i <= 6; i++) {
            //Comment p = new Comment();
            //p.setTitle("comment" + i);
            //p.setComment("commentDescription" + i);
            //p.setSayer("follower" + i);
            //comments.add(p);
       // }
        commentList.setItems(FXCollections.observableArrayList(comments));
        commentList.setCellFactory(commentList -> new CommentItem());
    }


    public void lastPage(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("showPostPage");
    }

    public void publishComment(ActionEvent actionEvent) throws NullPointerException {
        Comment comment = new Comment(Main.currentUsername,description.getText());
        comments.add(comment);

        commentList.setItems(FXCollections.observableArrayList(comments));
        commentList.setCellFactory(commentList -> new CommentItem());

        description.setText("");
    }
}

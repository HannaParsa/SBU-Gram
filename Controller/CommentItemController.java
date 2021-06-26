package Controller;

import Model.Comment;
import Model.Main;
import Model.PageLoader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class CommentItemController extends ListCell<Comment> {


    public ArrayList<Comment> comments = new ArrayList<>();
    public Comment currentComment = new Comment();
    public AnchorPane root;
    public Comment commentItem;
    public Label sayer;
    public Label title;
    public CommentItemController(Comment comment) throws IOException {
        new PageLoader().load("commentItem", this);
        this.commentItem = comment;
    }

    public AnchorPane init() {
        sayer.setText(commentItem.getSayer());
        title.setText(commentItem.getComment());
        return root;
    }

    public void lastPage(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("showPostPage");
    }

    public void CommentDetails(ActionEvent e) throws IOException {
        ShowCommentController.toShowComment = commentItem;
        new PageLoader().load("perCommentDetails");
    }
    public void publishComment(ActionEvent actionEvent) {

    }
}

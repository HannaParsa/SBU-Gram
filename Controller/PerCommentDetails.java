package Controller;

import Model.Comment;
import Model.Main;
import Model.PageLoader;
import Model.Post;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class PerCommentDetails {


    public Label sayer;
    public Label description;
    public Label titel;

    public void initialize() {
        description.setText(ShowCommentController.toShowComment.getComment());
        sayer.setText("@" + Main.currentUsername);
        //titel.setText(ShowCommentController.toShowComment.getTitle());
    }

    public void goPostDetails(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("showPostPage");
    }

    public void goMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("timeLine");
    }
}

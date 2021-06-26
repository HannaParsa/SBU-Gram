package Controller;

import Model.Comment;
import Model.Post;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class CommentItem extends ListCell<Comment> {

    @Override
    public void updateItem(Comment post, boolean empty) {
        super.updateItem(post, empty);
        if (post != null) {
            try {
                setGraphic(new CommentItemController(post).init());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

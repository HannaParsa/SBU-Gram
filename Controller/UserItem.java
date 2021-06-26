package Controller;

import Model.Post;
import Model.User;
import javafx.scene.control.ListCell;

import java.io.IOException;

public class UserItem extends ListCell<User> {

    @Override
    public void updateItem(User user, boolean empty) {
        super.updateItem(user, empty);
        if (user != null) {
            try {
                setGraphic(new UserItemController(user).init());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

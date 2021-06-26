package Controller;

import Model.Main;
import Model.PageLoader;
import Model.Post;
import Server.ServerHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class AllPostsController {

    public ListView <Post> postList;
    ArrayList<Post> posts = new ArrayList<>();
    public static Post toShowPost = null;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        posts = (ArrayList<Post>) ServerHandler.allPosts(Main.currentUsername);
        postList.setItems(FXCollections.observableArrayList(posts));
        postList.setCellFactory(postList -> new PostItem());
    }

    public void showPost(MouseEvent mouseEvent) throws NullPointerException, IOException, ClassNotFoundException {
        Post p = new Post();

        p.setTitle(postList.getSelectionModel().getSelectedItem().getTitle());

    }

    public void goMenu(ActionEvent actionEvent) throws IOException {
        new PageLoader().load("menu");
    }
}

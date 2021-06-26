package Controller;

import Model.Main;
import Model.PageLoader;
import Model.Post;
import Model.PrivacyStatus;
import Server.Repository;
import Server.Server;
import Server.ServerHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class TimeLine {
  public TextField title_field;
  public TextArea description_field;
  public ListView <Post> postList;
  public static Post toShowPost = null;
  public Button addPost_button;
  ArrayList<Post> posts = new ArrayList<>();
  Post currentPost = new Post();

  @FXML
  public void initialize() throws IOException, ClassNotFoundException {
    posts = (ArrayList<Post>) ServerHandler.postList(Main.currentUsername);
    postList.setItems(FXCollections.observableArrayList(posts));
    postList.setCellFactory(postList -> new PostItem());
  }

  public void addPost(ActionEvent actionEvent) throws IOException {
    new PageLoader().load("addPost");
  }

  public void showPost(MouseEvent mouseEvent) throws NullPointerException, IOException, ClassNotFoundException {
    Post p = new Post();

    p.setTitle(postList.getSelectionModel().getSelectedItem().getTitle());

    for (int i = 0; i < posts.size(); i++) {
      if (posts.get(i).equals(p)) {
        title_field.setText(posts.get(i).getTitle());
        description_field.setText(posts.get(i).getDescription());
      }
    }
  }

  public void goMenu(ActionEvent actionEvent) throws IOException {
    new PageLoader().load("menu");
  }

  public void goToPeople(ActionEvent actionEvent) throws IOException {
    new PageLoader().load("people");
  }
}

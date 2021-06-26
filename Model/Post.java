package Model;

import javafx.scene.image.Image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Post implements Serializable {
    public byte [] p;
    private String writer;
    private String title;
    private String description;
    private PrivacyStatus status;
    private String publisher;
    //private Image image ;
    private ArrayList<String> likes = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
    private ArrayList<String> reposts = new ArrayList<>();


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PrivacyStatus getStatus() {
        return status;
    }

    public void setStatus(PrivacyStatus status) {
        this.status = status;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) { this.writer = writer; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public byte[] getP() {
        return p;
    }

    public void setP(byte[] p) {
        this.p = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(title, post.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return title;
    }
    public int getLikes(){
        return likes.size();
    }

    public int getReposts(){
        return reposts.size();
    }

    public boolean like(String username){
        if (likes.contains(username))
            return false;
        likes.add(username);
        return true;
    }
    public boolean reposts(String username){
        if (reposts.contains(username))
            return false;
        reposts.add(username);
        return true;
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
}

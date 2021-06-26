package Model;

import java.io.Serializable;

public class Comment implements Serializable {
    String sayer;//writer
    String comment;//description
    private String title;
    public Comment(String sayer, String comment) {
        this.sayer = sayer;
        this.comment = comment;
    }

    public Comment() {
    }

    public String getComment() {
        return comment;
    }

    public String getSayer() {
        return sayer;
    }

    public String getTitle() {
        return title;
    }

    public void setSayer(String sayer) {
        this.sayer = sayer;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

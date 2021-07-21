package cursoUdemyNelio.exerciciosFixacao.exercComposicao02.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private Date moment;
    private String title;
    private String content;
    private Integer likes;

    List<Comment> comments = new ArrayList<>();


    public Post() {

    }

    public Post(Date moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    public String toString() {
        StringBuilder str = new StringBuilder();

        str.append(getTitle()).append("\n");
        str.append(getLikes()).append(" Likes - ").append(sdf.format(getMoment())).append("\n");
        str.append(getContent()).append("\n");
        str.append("Comments:" + "\n");
        for (Comment c : comments) {
            str.append(c.getText()).append("\n");
        }

        return str.toString();
    }

}

package cursoUdemyNelio.exerciciosFixacao.Composicao02.application;

import cursoUdemyNelio.exerciciosFixacao.Composicao02.entities.Comment;
import cursoUdemyNelio.exerciciosFixacao.Composicao02.entities.Post;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        Post post01 = new Post();
        post01.setMoment(sdf.parse("21/06/2018 13:05:44"));
        post01.setTitle("Traveling to New Zealand");
        post01.setContent("I'm going to visit this wonderful country");
        post01.setLikes(12);

        Comment c1 = new Comment("Have a nice trip");
        Comment c2 = new Comment("Wow that's awesome!");

        post01.addComment(c1);
        post01.addComment(c2);

        System.out.println(post01);

        System.out.println();

        Post post02 = new Post();
        post02.setMoment(sdf.parse("28/07/2018 23:14:19"));
        post02.setTitle("Good night guys");
        post02.setContent("See you tomorrow");
        post02.setLikes(5);

        Comment c3 = new Comment("Good night");
        Comment c4 = new Comment("May the force be with you");

        post02.addComment(c3);
        post02.addComment(c4);

        System.out.println(post02);

    }
}

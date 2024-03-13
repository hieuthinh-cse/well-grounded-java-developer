import config.ProjectConfig;
import entity.Comment;
import entity.Homelander;
import service.CommentService;
import service.NotificationService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Homelander h = context.getBean(Homelander.class);
        System.out.println(h.getClass());


        var n = context.getBean(NotificationService.class);
        System.out.println(n.getClass());

        var service = context.getBean(CommentService.class);

        Comment comment = new Comment("Demo comment", "Natasha");

        service.publishComment(comment);

        System.out.println(service.getClass());
    }
}

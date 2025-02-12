import java.util.ArrayList;
import java.util.Arrays;

import main.java.entity.ContentType;
import main.java.entity.User;
import main.java.service.AnswerService;
import main.java.service.EngagementService;
import main.java.service.QuestionService;

public class App {
    
    static QuestionService questionService = new QuestionService();

    static AnswerService answerService = new AnswerService();

    static EngagementService engagementService = new EngagementService();

    public static void main(String[] args) throws Exception {

        User batman = new User("Bruce", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0);

        int questionId = questionService.postQuestion(batman, "Who is Two Face?", Arrays.asList("Crime","Gotham","Joker"));

        User superman = new User("Clark",  new ArrayList<>(),  new ArrayList<>(),  new ArrayList<>(), 0);

        answerService.postAnswer(superman, "Harvey Dent is Two Face", questionId);

        User joker = new User("Joker", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), 0);

        engagementService.comment(joker, "Why So Serious", ContentType.QUESTION, questionId);

        engagementService.vote(joker, ContentType.QUESTION, questionId);
    }
}

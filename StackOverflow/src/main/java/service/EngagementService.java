package main.java.service;

import main.java.entity.ContentType;
import main.java.entity.User;

public class EngagementService {

    QuestionService questionService = new QuestionService();
    AnswerService answerService = new AnswerService();

    public void comment(User user, String desc, ContentType contentType, int contentId){
        if (contentType.equals(ContentType.QUESTION))
            questionService.addComment(user, desc, contentId);
        else
            answerService.addComment(user, desc, contentId);
    }

    public void vote(User user, ContentType contentType, int contentId){
        if (contentType.equals(ContentType.QUESTION))
            questionService.addVote(user, contentId);
        else
            answerService.addVote(user, contentId);
    }
}

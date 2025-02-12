package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.entity.Answer;
import main.java.entity.Comment;
import main.java.entity.Question;
import main.java.entity.User;
import main.java.repository.AnswerRepository;
import main.java.repository.QuestionRepository;

public class AnswerService {

    List<Answer> answers = AnswerRepository.answers;
    List<Question> questions = QuestionRepository.questions;

    public void postAnswer(User user, String desc, int questionId){
        Answer answer = new Answer(desc, 0, new ArrayList<>());

        user.answers.add(answer);

        questions.stream()
            .filter(q -> q.id == questionId)
            .findFirst()
            .ifPresent(q -> q.answers.add(answer));

        System.out.println("Answer Posted Successfully");
    }

    public void addComment(User user, String desc, int answerId){
        Comment comment = new Comment(desc);

        answers.stream()
            .filter(ans -> ans.id == answerId)
            .findFirst()
            .ifPresent(ans -> ans.comments.add(comment));

        user.comments.add(comment);
        System.out.println("Comment added Successfully");
    }

    public void addVote(User user, int answerId){

        answers.stream()
            .filter(ans -> ans.id == answerId)
            .findFirst()
            .ifPresent(ans -> ans.votes++);

        System.out.println("Voted Successfully");
    }
}

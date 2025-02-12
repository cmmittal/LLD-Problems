package main.java.service;

import java.util.ArrayList;
import java.util.List;

import main.java.entity.Comment;
import main.java.entity.Question;
import main.java.entity.User;
import main.java.repository.QuestionRepository;
import main.java.repository.UserRepository;

public class QuestionService {

    List<Question> questions = QuestionRepository.questions;
    List<User> users = UserRepository.users;

    public int postQuestion(User user, String desc, List<String> tags){
        Question question = new Question(desc, 0, tags, new ArrayList<>(), new ArrayList<>());

        user.questions.add(question);

        QuestionRepository.questions.add(question);

        System.out.println("Question Posted Successfully");

        return question.id;
    }

    public void addComment(User user, String desc, int questionId){
        Comment comment = new Comment(desc);

        questions.stream()
            .filter(q -> q.id == questionId)
            .findFirst()
            .ifPresent(q -> q.comments.add(comment));

        user.comments.add(comment);

        System.out.println("Comment added Successfully");
    }

    public void addVote(User user, int questionId){

        questions.stream()
            .filter(q -> q.id == questionId)
            .findFirst()
            .ifPresent(q -> q.votes++);

        System.out.println("Voted Successfully");
    }

    public void search(String keywords, List<String> tags, String user){
        List<Question> filteredQuestions = new ArrayList<>();

        for (Question question : questions) {
            if (question.desc.contains(keywords)) {
                filteredQuestions.add(question);
            }
        }

        for (String tag : tags) {
            for (Question question : questions) {
                if (question.tags.contains(tag)) {
                    filteredQuestions.add(question);
                }
            }
        }

        for (User u : users) {
            if (u.userName.equals(user)) {
                filteredQuestions.addAll(u.questions);
            }
        }

        for (Question question : filteredQuestions) {
            System.out.println(question);
        }
    }
}

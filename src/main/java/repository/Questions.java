package repository;

import entity.Question;
import java.util.Map;

public class Questions {

    //  инициализация
    private final static Map<Integer, Question> questionList = QuestionFactory.loadQuestions();

    public Question getById(int id) {
        return questionList.get(id);
    }
}
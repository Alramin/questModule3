package entity;

import lombok.Getter;
import lombok.ToString;
import java.util.List;

@Getter
@ToString
public class Question {
    private int id;
    private String text;
    private List<Answers> answerList;

    //  конструктор для фабрики
    public Question() {
    }

    // конструктор для тестов
    public Question(int id, String text, List<Answers> answerList) {
        this.id = id;
        this.text = text;
        this.answerList = answerList;
    }
}


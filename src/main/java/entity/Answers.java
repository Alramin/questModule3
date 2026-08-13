package entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Answers {
    private  String text;
    private  boolean wrongAnswer;
    private String wrongAnswerEndText;

    public Answers(String text, String wrongAnswerEndText) {
        this.text = text;
        this.wrongAnswerEndText = wrongAnswerEndText;
        this.wrongAnswer = true;
    }

    public Answers(String text) {
        this.text = text;
        this.wrongAnswer = false;
    }
}

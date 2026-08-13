package entity;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EntityTest {

    @Test
    void testUserCreation_ShouldInitializeWithZeroGames() {

        User user = new User("Капитан Смоллетт");
        assertEquals(0, user.getLostGames(), "Изначально количество проигранных игр должно быть 0");
        assertEquals(0, user.getWonGames(), "Изначально количество выигранных игр должно быть 0");
    }

    @Test
    void testAnswersConstructor_CorrectAnswer_ShouldSetWrongAnswerFalse() {

        Answers correct = new Answers("Принять вызов");
        assertEquals("Принять вызов", correct.getText());
        assertFalse(correct.isWrongAnswer(), "Для правильного ответа flag wrongAnswer должен быть false");
        assertNull(correct.getWrongAnswerEndText(), "Для правильного ответа текст поражения должен быть null");
    }

    @Test
    void testAnswersConstructor_WrongAnswer_ShouldSetWrongAnswerTrue() {
        Answers wrong = new Answers("Отклонить вызов", "Вы сдались. Поражение.");
        assertEquals("Отклонить вызов", wrong.getText());
        assertTrue(wrong.isWrongAnswer(), "Для неверного ответа flag wrongAnswer должен быть true");
        assertEquals("Вы сдались. Поражение.", wrong.getWrongAnswerEndText());
    }

    @Test
    void testQuestionConstructorAndGetters() {
        Answers ans1 = new Answers("Да");
        Answers ans2 = new Answers("Нет");
        List<Answers> answersList = List.of(ans1, ans2);
        Question question = new Question(42, "Хочешь стать джедаем?", answersList);
        assertEquals(42, question.getId());
        assertEquals("Хочешь стать джедаем?", question.getText());
        assertEquals(2, question.getAnswerList().size(), "Список ответов должен содержать 2 элемента");
        assertEquals("Да", question.getAnswerList().get(0).getText());
    }
}
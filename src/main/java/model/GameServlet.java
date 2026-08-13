package model;

import entity.Answers;
import entity.Question;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import repository.Questions;
import services.Counter;
import services.UserInit;

import java.io.IOException;

@WebServlet(name = "model.GameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        Questions questions = new Questions();

        // достаем счетчик конкретного пользователя из сессии
        Counter counter = (Counter) session.getAttribute("gameCounter");
        if (counter == null) {
            counter = new Counter();
            session.setAttribute("gameCounter", counter);
        }

        //  достаем текущий вопрос и ответ пользователя
        Question currentQuestion = getCurrentQuestion(session);
        Answers currentAnswer = (currentQuestion != null) ? getCurrentAnswer(currentQuestion, req) : null;

        Question nextQuestion = null;

        // логика переходов по вопросам
        if (currentQuestion == null) {
            //  первый шаг игры
            nextQuestion = questions.getById(1);
        } else if (currentAnswer != null) {
            // Обработка ответа пользователя
            if (!currentAnswer.isWrongAnswer()) {
                nextQuestion = questions.getById(currentQuestion.getId() + 1);

                // Проверка на победный финал квеста (слово "Да")
                if ("Да".equals(currentAnswer.getText())) {
                    counter.winCount();
                }
            } else {
                // Игрок выбрал неверный ответ (поражение)
                session.setAttribute("wrongAnswer", currentAnswer);
                counter.loseCount();
            }
        }

        //  Запись обновленных данных состояния в сессию
        session.setAttribute("question", nextQuestion);
        session.setAttribute("ipaddress", req.getRemoteAddr());
        session.setAttribute("loseCounter", counter.getCountLose());
        session.setAttribute("winCounter", counter.getCountWin());

        if (nextQuestion != null) {
            session.setAttribute("endIndex", nextQuestion.getAnswerList().size() - 1);
        }

        //  Перенаправление пользователя на интерфейс игры
        resp.sendRedirect(req.getContextPath() + "/quest.jsp");
    }

    private Question getCurrentQuestion(HttpSession session) {

        return (Question) session.getAttribute("question");
    }

    private Answers getCurrentAnswer(Question currentQuestion, HttpServletRequest req) {
        try {
            String answerParam = req.getParameter("answerId");
            if (answerParam == null) return null;

            int answerId = Integer.parseInt(answerParam);
            return currentQuestion.getAnswerList().get(answerId);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String userName = req.getParameter("firstName");

        HttpSession session = req.getSession();
        session.setAttribute("questId", "quest1");
        req.setAttribute("questId", "quest1");

        resp.setContentType("text/html;charset=utf-8");
        UserInit.addUser(session, userName);

        doGet(req, resp);
    }
}
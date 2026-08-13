package model;

import entity.Answers;
import entity.Question;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.Counter;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameServletTest {

    private GameServlet gameServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        gameServlet = new GameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("");
    }

    @Test
    void testDoGet_FirstStart_ShouldSetFirstQuestion() throws IOException {
        when(session.getAttribute("question")).thenReturn(null);
        when(session.getAttribute("gameCounter")).thenReturn(new Counter());

        gameServlet.doGet(request, response);

        verify(session).setAttribute(eq("question"), argThat(argument ->
                argument instanceof Question && ((Question) argument).getId() == 1
        ));
        verify(response).sendRedirect("/quest.jsp");
    }

    @Test
    void testDoGet_CorrectAnswer_ShouldMoveToNextQuestion() throws IOException {

        Answers correctAnswer = new Answers("Правильный ответ");
        Question currentQuestion = new Question(1, "Тестовый вопрос 1", List.of(correctAnswer));

        when(session.getAttribute("question")).thenReturn(currentQuestion);
        when(session.getAttribute("gameCounter")).thenReturn(new Counter());
        when(request.getParameter("answerId")).thenReturn("0");

        gameServlet.doGet(request, response);

        verify(session).setAttribute(eq("question"), argThat(argument ->
                argument instanceof Question && ((Question) argument).getId() == 2
        ));
    }

    @Test
    void testDoGet_WinningAnswer_ShouldIncrementWinCounter() throws IOException {
        Answers winningAnswer = new Answers("Да");
        Question finalQuestion = new Question(4, "Хочешь домой?", List.of(winningAnswer));
        Counter counter = new Counter();
        when(session.getAttribute("question")).thenReturn(finalQuestion);
        when(session.getAttribute("gameCounter")).thenReturn(counter);
        when(request.getParameter("answerId")).thenReturn("0");
        gameServlet.doGet(request, response);
        assertEquals(1, counter.getCountWin());
        verify(session).setAttribute("winCounter", 1);
    }
}
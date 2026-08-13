package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class NewGameServletTest {

    private NewGameServlet restartServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @BeforeEach
    void setUp() {
        restartServlet = new NewGameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("");
    }

    @Test
    void testDoGet_ShouldInvalidateSessionAndRedirectToStart() throws IOException {

        restartServlet.doGet(request, response);


        verify(session).invalidate();


        verify(response).sendRedirect("/start");
    }
}
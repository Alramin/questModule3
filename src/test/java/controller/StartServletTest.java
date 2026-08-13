package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

class StartServletTest {

    private StartServlet startServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private ServletContext servletContext;
    private RequestDispatcher requestDispatcher;

    @BeforeEach
    void setUp() {
        startServlet = new StartServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        requestDispatcher = mock(RequestDispatcher.class);


        when(request.getSession(true)).thenReturn(session);
        startServlet = spy(startServlet);
        doReturn(servletContext).when(startServlet).getServletContext();
    }

    @Test
    void testDoGet_ShouldCreateSessionAndForwardToIndex() throws ServletException, IOException {
        when(servletContext.getRequestDispatcher("/index.jsp")).thenReturn(requestDispatcher);
        startServlet.doGet(request, response);
        verify(request).getSession(true);
        verify(servletContext).getRequestDispatcher("/index.jsp");
        verify(requestDispatcher).forward(request, response);
    }
}
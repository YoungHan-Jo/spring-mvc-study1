package hello.servletprac.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/request-param?username=hello&age=20
 * <p>
 * 2. 동일한 파라미터 전송 가능
 * http://localhost:8080/request-param?username=hello&username=kim&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + ": " + request.getParameter(paramName)));

        String[] usernames = request.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }

        response.getWriter().write("ok");

    }
}

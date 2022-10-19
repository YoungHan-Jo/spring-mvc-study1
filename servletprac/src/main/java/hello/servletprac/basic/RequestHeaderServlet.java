package hello.servletprac.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getHeaderNames().asIterator()
                .forEachRemaining(headName -> System.out.println(headName + ": " + request.getHeader(headName)));

        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));

        Cookie[] cookies = request.getCookies();

    }

}

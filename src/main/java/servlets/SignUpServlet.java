package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;
    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {



        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (login == null || password == null || email == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Empty fields");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        if (accountService.getUserByLogin(login) != null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println(login + " is registered already");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile userProfile = new UserProfile(login, password, email);
        accountService.addNewUser(userProfile);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("Registered: " + login);
        response.setStatus(HttpServletResponse.SC_OK);


    }
}

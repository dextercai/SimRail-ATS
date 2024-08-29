package rin.simrail.web;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@WebServlet(value = "/run", asyncSupported = true)
public class Run extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var server = request.getParameter("server");
        var carNumber = request.getParameter("carnumber");
        var args = Craw.craw(new String[]{server, carNumber});
        for (var arg : args) {
            System.out.println(arg);
        }
        response.setContentType("text/html");
        request.getRequestDispatcher("run.jsp").forward(request, response);
    }
}
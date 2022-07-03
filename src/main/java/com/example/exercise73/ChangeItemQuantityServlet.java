package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "changeItemQuantityServlet", value = "/change-item-quantity-servlet")
public class ChangeItemQuantityServlet extends HttpServlet {
    public void init(){}

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html><body>");
        out.println("<h1> Item quantity successfully changed. </h1>");
        out.println("</body></html>");
    }
}

package com.example.exercise73;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {
    private BasketMethods basketMethods;

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Shopping Basket Management </h1>");
        out.println("<h2> Select a method </h2>");
        out.println("<form><SELECT id =\"chooseMethod\" NAME=\"Choose a method\"> " +
                "<OPTION id = \"add\"> Add an item\n" +
                "<OPTION id = \"search\"> Search an item\n" +
                "<OPTION id = \"show\"> Show all items of a basket\n" +
                "<OPTION id = \"change\"> Change the quantity of a shopping item\n" +
                " </SELECT></form>");
        out.println("</body></html>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String chosenMethod = request.getParameter("chooseMethod");
        PrintWriter out = response.getWriter();
        out.write(chosenMethod);
        switch (chosenMethod){
            case "add":
                response.sendRedirect("/add-item-servlet");
                break;
            case "search":
                response.sendRedirect("/search-item-servlet");
                break;
            case "show":
                response.sendRedirect("/get-all-items-servlet");
                break;
            case "change":
                response.sendRedirect("/change-item-quantity-servlet");
                break;


        }


    }


    public void destroy() {
    }
}
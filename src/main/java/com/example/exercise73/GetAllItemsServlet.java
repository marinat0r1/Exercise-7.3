package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getAllItemsServlet", value = "/get-all-items-servlet")
public class GetAllItemsServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ShoppingBasket basket = (ShoppingBasket) request.getSession().getAttribute("basket");

        out.println("<html><body>");
        out.println("<h1> Basket Overview </h1>");
        for (ShoppingItem item : basket.getItems()) {
            out.println(" Name: " + item.getName() + " Price: " + item.getPrice() + " Quantity: " + item.getQuantity() + "<br/>");
        }
        out.println("</body></html>");
    }
}

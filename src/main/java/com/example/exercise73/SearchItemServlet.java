package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "searchItemServlet", value = "/search-item-servlet")
public class SearchItemServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String searchedItem = (String) request.getSession().getAttribute("searchedItem");
        ShoppingBasket basket = (ShoppingBasket) request.getSession().getAttribute("basket");

        ShoppingItem item = basket.searchItem(searchedItem);

        out.println("<html><body>");
        out.println("<h1> Search item </h1>");
        out.println(" Name: " + item.getName() + " Price: " + item.getPrice() + " Quantity: " + item.getQuantity() + "<br/>");
        out.println("</body></html>");
    }
}

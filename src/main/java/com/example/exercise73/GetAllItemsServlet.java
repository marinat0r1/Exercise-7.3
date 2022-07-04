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
            out.println(" Name: " + item.getName() + " Price: " + item.getPrice() + " Quantity: " + item.getQuantity() +"<br/>");
        }
        out.println("<h2> Select a method </h2>");
        out.println("<form method=\"POST\">\n" +
                "      <input type=\"submit\" name=\"choice\" value=\"Add an item\">\n" +
                "    </form>");
        out.println("<form method=\"POST\">\n" +
                "      <input id=search type=\"submit\" name=\"choice\" value=\"Search for an item\">\n" +
                "    </form>");
        out.println("<form method=\"POST\">\n" +
                "      <input id=change type=\"submit\" name=\"choice\" value=\"Change an items quantity\">\n" +
                "    </form>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String chosenMethod = request.getParameter("choice");
        PrintWriter out = response.getWriter();

        switch (chosenMethod){
            case "Add an item":
                response.sendRedirect(request.getContextPath() + "/data-for-add-item-servlet");
                break;
            case "Search for an item":
                response.sendRedirect(request.getContextPath() + "/search-item-data-servlet");
                break;
            case "Change an items quantity":
                response.sendRedirect(request.getContextPath() + "/change-item-quantity-data-servlet");
                break;
            default:
                break;

        }
    }

}

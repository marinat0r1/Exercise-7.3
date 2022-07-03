package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "changeItemQuantityDataServlet", value = "/change-item-quantity-data-servlet")
public class ChangeItemQuantityDataServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Change item quantity</h1>");
        out.println("<form name = \"searchItemForm\" method =\"post\" > " +
                "Item Name: <input type=\"text\" name=\"itemName\"> <br/>" +
                "Items new Quantity: <input type=\"text\" name=\"itemNewQuantity\"> <br/>" +
                "<input type=\"submit\" value=\"Change Quantity\" /> </form> ");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String item = request.getParameter("itemName");
        int quantity = Integer.parseInt(request.getParameter("itemNewQuantity").trim());
        ShoppingBasket basket = (ShoppingBasket) request.getSession().getAttribute("basket");

        basket.searchItem(item).setQuantity(quantity);

        response.sendRedirect(request.getContextPath() + "/change-item-quantity-servlet");


    }
}


package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "dataForAddItemServlet", value = "/data-for-add-item-servlet")
public class DataForAddItemServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Add item to basket </h1>");
        out.println("<form name = \"addItemForm\" method =\"post\" > " +
                "Item Name: <input type=\"text\" name=\"itemName\"> <br/>" +
                "Item Price: <input type=\"text\" name=\"itemPrice\"> <br/>" +
                "Item Quantity: <input type=\"text\" name=\"itemQuantity\"> <br/>" +
                "<input type=\"submit\" value=\"Add Item\" /> </form> ");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();


        ShoppingBasket basket = (ShoppingBasket) request.getSession().getAttribute("basket");
        basket.addItemToBasket(request.getParameter("itemName"),
                Integer.parseInt(request.getParameter("itemPrice").trim()),
                Integer.parseInt(request.getParameter("itemQuantity").trim()));

        response.sendRedirect(request.getContextPath() + "/add-item-servlet");

    }

    public void destroy() {
    }
}

package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "searchItemDataServlet", value = "/search-item-data-servlet")
public class SearchItemDataServlet extends HttpServlet {
    public void init(){}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1> Search item </h1>");
        out.println("<form name = \"searchItemForm\" method =\"post\" > " +
                "Item Name: <input type=\"text\" name=\"itemName\"> <br/>" +
                "<input type=\"submit\" value=\"Search Item\" /> </form> ");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.getSession().setAttribute("searchedItem", request.getParameter("itemName"));

        response.sendRedirect(request.getContextPath() + "/search-item-servlet");

    }
}

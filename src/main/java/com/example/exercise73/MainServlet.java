package com.example.exercise73;

import java.io.*;
import java.util.HashSet;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/main-servlet")
public class MainServlet extends HttpServlet {

    private ShoppingBasket shoppingBasket = new ShoppingBasket("basket", new HashSet<>());

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        session.setAttribute("basket", shoppingBasket);

        out.println("<html><body>");
        out.println("<h1> Shopping Basket Management </h1>");
        out.println("<h2> Select a method </h2>");
        out.println("<form method=\"POST\">\n" +
                "      <input type=\"submit\" name=\"choice\" value=\"Add an item\">\n" +
                "    </form>");
        out.println("<form method=\"POST\">\n" +
                "      <input id=search type=\"submit\" name=\"choice\" value=\"Search for an item\">\n" +
                "    </form>");
        out.println("<form method=\"POST\">\n" +
                "      <input id=show type=\"submit\" name=\"choice\" value=\"Show all items\">\n" +
                "    </form>");
        out.println("<form method=\"POST\">\n" +
                "      <input id=change type=\"submit\" name=\"choice\" value=\"Change an items quantity\">\n" +
                "    </form>");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String chosenMethod = request.getParameter("choice");
        PrintWriter out = response.getWriter();

        //response.sendRedirect(request.getContextPath() + "/add-item-servlet");

        switch (chosenMethod){
            case "Add an item":
                response.sendRedirect(request.getContextPath() + "/data-for-add-item-servlet");
                break;
            case "Search for an item":
                response.sendRedirect(request.getContextPath() + "/search-item-data-servlet");
                break;
            case "Show all items":
                response.sendRedirect(request.getContextPath() + "/get-all-items-servlet");
                break;
            case "Change an items quantity":
                response.sendRedirect(request.getContextPath() + "/change-item-quantity-data-servlet");
                break;
            default:
                break;

        }

    }

    public void destroy() {
    }
}
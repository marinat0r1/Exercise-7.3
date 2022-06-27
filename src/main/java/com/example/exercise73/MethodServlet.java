package com.example.exercise73;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "methodServlet", value = "/method-servlet")
public class MethodServlet extends HttpServlet {

    public void init(){}

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }
}

package com.example.webnew.web;

import com.example.webnew.PostgresSQLStorage;
import com.example.webnew.PrintedProduct;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = {"/items"})
public class ProductServlet extends HttpServlet {
    private PostgresSQLStorage st;
    @Override
    public void init() throws ServletException {
        super.init();
        st = PostgresSQLStorage.getInstance();
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            List<PrintedProduct> products = st.showAllEl();
//            resp.getWriter().println(products.stream().map(PrintedProduct::getTitle)
//                    .collect(Collectors.joining(",")));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//


    private final Logger logger = Logger.getLogger(ProductServlet.class.getCanonicalName());
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        final List<PrintedProduct> items;
        try {
            items = st.showAllEl();
            req.setAttribute("items", items);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(req,resp);
    }
    }


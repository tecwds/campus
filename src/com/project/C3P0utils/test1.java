package com.project.C3P0utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/getBook")
public class test1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        QueryRunner queryRunner=new QueryRunner(C3P0Utils.getDataSource());
        String sql="Select * From goods";
        goodsbeans goods=new goodsbeans();

        try {
            goods = queryRunner.query(sql,new BeanHandler<>(goodsbeans.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("id",goods.getId());
        req.setAttribute("name",goods.getName());
        req.setAttribute("price",goods.getPrice());

        resp.sendRedirect("/test.jsp?id="+goods.getId()+"&"+"name="+goods.getName()+"&"+"price="+goods.getPrice());
    }
}

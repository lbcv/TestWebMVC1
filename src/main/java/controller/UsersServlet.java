package controller;

import pojo.Users;
import service.impl.UsersService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UsersServlet", value = "/usersServlet")
public class UsersServlet extends HttpServlet {
    private UsersService usersService = new UsersService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1获取用户提交的信息
        int id = Integer.parseInt(request.getParameter("id").toString());
        String name = request.getParameter("name").toString();
        int age = Integer.parseInt(request.getParameter("age").toString());
        Users users = new Users(id, name, age);

        int i = usersService.addUsers(users);
        //2调用service层做添加用户的逻辑处理
        if(i>0)
            response.getWriter().print("添加成功");
        else
            response.getWriter().print("添加失败");

        //3返回结果
    }
}

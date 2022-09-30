package dao.impl;

import dao.IUsersDao;
import pojo.Users;
import util.DbHelper;

import java.util.ArrayList;
import java.util.List;

public class UsersDao implements IUsersDao {
    @Override
    public int addUsers(Users users) {
        String sql = "insert into users values(?,?,?)";

        List<Object> paramList = new ArrayList<>();
        paramList.add(users.getId());
        paramList.add(users.getName());
        paramList.add(users.getAge());

        DbHelper dbHelper = new DbHelper();
        return dbHelper.executeUpdate(sql,paramList);
    }
}

package dao.impl;

import dao.IUsersDao;
import pojo.Users;
import util.DbHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersDao implements IUsersDao {
    private DbHelper dbHelper = new DbHelper();
    @Override
    public int addUsers(Users users) {
        String sql = "insert into users values(?,?,?)";

        List<Object> paramList = new ArrayList<>();
        paramList.add(users.getId());
        paramList.add(users.getName());
        paramList.add(users.getAge());

        return dbHelper.executeUpdate(sql,paramList);
    }

    @Override
    public List<Map<String, Object>> qureyUsers() {
        String sql = "select * from users";

        return dbHelper.executeQuery(sql,null);
    }
}

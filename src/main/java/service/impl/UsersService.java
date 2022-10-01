package service.impl;

import dao.impl.UsersDao;
import pojo.Users;
import service.IUsersService;

import java.util.List;
import java.util.Map;

public class UsersService implements IUsersService {
    private UsersDao usersDao = new UsersDao();
    @Override
    public int addUsers(Users users) {

        return usersDao.addUsers(users);
    }

    @Override
    public List<Map<String, Object>> qureyUsers() {
        return usersDao.qureyUsers();
    }
}

package service.impl;

import dao.impl.UsersDao;
import pojo.Users;
import service.IUsersService;

public class UsersService implements IUsersService {
    private UsersDao usersDao = new UsersDao();
    @Override
    public int addUsers(Users users) {

        return usersDao.addUsers(users);
    }
}

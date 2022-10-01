package service;

import pojo.Users;

import java.util.List;
import java.util.Map;

public interface IUsersService {
    public int addUsers(Users users);
    public List<Map<String,Object>> qureyUsers();
}

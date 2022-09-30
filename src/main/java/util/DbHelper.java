package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class DbHelper {
    private Connection connection;
    public DbHelper(){
        getConnection();
    }

    public void getConnection(){

        try {
            if(connection==null || connection.isClosed()){
                InputStream inputStream = this.getClass().getResourceAsStream("/db.properties");

                Properties properties = new Properties();
                properties.load(inputStream);
                String driver = properties.getProperty("driver");
                String url = properties.getProperty("url");
                String user = properties.getProperty("user");
                String pwd = properties.getProperty("pwd");

                Class.forName(driver);
//                String url = "jdbc:mysql://localhost:3306/ecust";
//                String user = "root";
//                String pwd = "ROOT";
                this.connection = DriverManager.getConnection(url,user,pwd);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String sql, List<Object> paramList){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(paramList!=null){
                for (int i = 0; i < paramList.size(); i++) {
                    preparedStatement.setObject(i+1,paramList.get(i));
                }
            }
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
    }

    public List<Map<String,Object>> executeQuery(String sql, List<Object> paramList){
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            if(paramList!=null){
                for (int i = 0; i < paramList.size(); i++) {
                    statement.setObject(i+1,paramList.get(i));
                }
            }
            ResultSet resultSet = statement.executeQuery();

            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            List<Map<String,Object>> list = new ArrayList<>();

            while (resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                    String columnName = resultSetMetaData.getColumnName(i);
                    Object columnValues = resultSet.getObject(columnName);
                    map.put(columnName,columnValues);
                }
                list.add(map);
            }
            return list;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}

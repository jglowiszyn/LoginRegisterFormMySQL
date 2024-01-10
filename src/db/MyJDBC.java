package db;

import constans.CommonConstants;

import java.sql.*;

public class MyJDBC {
    public static boolean register(String username, String password){

        try{
            if(!checkUser(username)){
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                        CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);

                PreparedStatement insertUser = connection.prepareStatement(
                        "INSERT INTO " + CommonConstants.DB_USERS_TABLE_NAME + "(username, password)" +
                                "VALUES(?, ?)"
                );

                insertUser.setString(1,username);
                insertUser.setString(2,password);

                insertUser.executeUpdate();
                return true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public static boolean checkUser(String username){
        try{
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * FROM " + CommonConstants.DB_USERS_TABLE_NAME +
                            " WHERE USERNAME = ?"
            );
            checkUserExists.setString(1, username);

            ResultSet resultSet = checkUserExists.executeQuery();

            if(!resultSet.isBeforeFirst()){
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

}

package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SQLUtil {
    public static <T> T execute(String sql,Object... obj)  throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();

        PreparedStatement pstm = connection.prepareStatement(sql);

        System.out.println(sql);

        for (int i = 0; i < obj.length; i++) {

            pstm.setObject((i+1),obj[i]);

        }


        if (sql.startsWith("SELECT")){
            return (T) pstm.executeQuery();

        } else {
            return (T)(Boolean)(pstm.executeUpdate() > 0);

        }
    }

//    public static <T> T execute(Object... obj)  throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//
//        PreparedStatement pstm = connection.prepareStatement((String) obj[0]);
//        System.out.println((String) obj[0]);
//
//        for (int i = 1; i < obj.length; i++) {
//            Object o =  obj[i];
//            System.out.println(o);
//            pstm.setObject(i,obj[i]);
//        }
//
//        if (((String) obj[0]).startsWith("SELECT")){
//
//            return (T) pstm.executeQuery();
//
//        } else {
//            return (T)(Boolean)(pstm.executeUpdate() > 0);
//
//        }
//    }

}

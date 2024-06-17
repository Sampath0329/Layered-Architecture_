package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.dao.ItemDAOImpl;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemBoImpl {
    ItemDAO itemDAO = new ItemDAOImpl();
    public String getCurrentId() throws SQLException, ClassNotFoundException {

        return itemDAO.getCurrentId();
    }


    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                orderDTO.getOrderId(), Date.valueOf(orderDTO.getOrderDate()), orderDTO.getCustomerId() );

    }


    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return resultSet.next();
    }

}

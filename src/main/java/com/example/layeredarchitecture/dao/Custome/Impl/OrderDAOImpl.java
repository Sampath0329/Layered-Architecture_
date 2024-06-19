package com.example.layeredarchitecture.dao.Custome.Impl;

import com.example.layeredarchitecture.dao.Custome.OrderDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public String getNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString(1).replace("OID-", "")) + 1)) : "ODI-001";


    }

    @Override
    public boolean save(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",
                orderDTO.getOrderId(),Date.valueOf(orderDTO.getOrderDate()), orderDTO.getCustomerId() );

    }

    @Override
    public boolean exist(String orderId) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?",orderId);
        return resultSet.next();
    }

    @Override
    public boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {return false;}

    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {return null;}


    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {}
}

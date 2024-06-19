package com.example.layeredarchitecture.dao.Custome.Impl;

import com.example.layeredarchitecture.dao.Custome.OrderDetailsDAO;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public boolean save(OrderDetailDTO detail) throws SQLException, ClassNotFoundException {

        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",
                detail.getOid(),detail.getItemCode(),detail.getUnitPrice(),detail.getQty());
    }

    @Override
    public boolean update(OrderDetailDTO orderDetailDTO) throws SQLException, ClassNotFoundException {return false;}

    @Override
    public ArrayList<OrderDetailDTO> getAll() throws SQLException, ClassNotFoundException {return null;}

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {return false;}

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {}

    @Override
    public String getNewId() throws SQLException, ClassNotFoundException {return null;}
}

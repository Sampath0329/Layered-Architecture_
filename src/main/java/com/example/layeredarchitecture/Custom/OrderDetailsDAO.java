package com.example.layeredarchitecture.Custom;

import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailDTO>{
    boolean save(OrderDetailDTO detail) throws SQLException, ClassNotFoundException;
}
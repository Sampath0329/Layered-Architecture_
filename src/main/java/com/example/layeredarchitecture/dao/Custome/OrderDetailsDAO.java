package com.example.layeredarchitecture.dao.Custome;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public interface OrderDetailsDAO extends CrudDAO<OrderDetailDTO> {
    boolean save(OrderDetailDTO detail) throws SQLException, ClassNotFoundException;
}

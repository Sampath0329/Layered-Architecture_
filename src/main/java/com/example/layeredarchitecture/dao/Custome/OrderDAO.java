package com.example.layeredarchitecture.dao.Custome;

import com.example.layeredarchitecture.dao.CrudDAO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.SQLException;

public interface OrderDAO extends CrudDAO<OrderDTO> {

    OrderDTO getOrder(String newValue) throws SQLException, ClassNotFoundException;
}

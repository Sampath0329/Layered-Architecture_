package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderBO {
     String getNewOrderId() throws SQLException, ClassNotFoundException;
     boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
     boolean existOrder(String orderId) throws SQLException, ClassNotFoundException ;
     boolean saveOrderDetail(OrderDetailDTO detail) throws SQLException, ClassNotFoundException ;
     boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
     ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException;
     void delete(String id) throws SQLException, ClassNotFoundException ;
}

package com.example.layeredarchitecture.BO.Custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SearchOrderBO {
    boolean existOrder(String orderId) throws SQLException, ClassNotFoundException;

    OrderDTO getOrder(String orderId) throws SQLException, ClassNotFoundException;

    ArrayList<OrderDetailDTO> getAllOderDetails(String orderId) throws SQLException, ClassNotFoundException;


    ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException;

    CustomerDTO getCustomer(String customerId) throws SQLException, ClassNotFoundException;

    ItemDTO getItem(String itemCode) throws SQLException, ClassNotFoundException;
}

package com.example.layeredarchitecture.BO.Custom.Impl;

import com.example.layeredarchitecture.BO.Custom.CustomerBO;
import com.example.layeredarchitecture.BO.Custom.ItemBO;
import com.example.layeredarchitecture.BO.Custom.OrderBO;
import com.example.layeredarchitecture.BO.Custom.SearchOrderBO;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SearchOrderBOImpl implements SearchOrderBO {

    OrderBO orderBO = new OrderBOImpl();
    CustomerBO customerBO = new CustomerBOImpl();

    ItemBO itemBO = new ItemBOImpl();
    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {
        return orderBO.existOrder(orderId);
    }

    @Override
    public OrderDTO getOrder(String orderId) throws SQLException, ClassNotFoundException {
        return orderBO.getOrder(orderId);
    }

    @Override
    public ArrayList<OrderDetailDTO> getAllOderDetails(String orderId) throws SQLException, ClassNotFoundException {
        return orderBO.getAllOderDetails(orderId);
    }

    @Override
    public ArrayList<OrderDTO> getAllOrders() throws SQLException, ClassNotFoundException {
        return orderBO.getAll();
    }

    @Override
    public CustomerDTO getCustomer(String customerId) throws SQLException, ClassNotFoundException {
        return customerBO.getCustomer(customerId);
    }

    @Override
    public ItemDTO getItem(String itemCode) throws SQLException, ClassNotFoundException {
        return itemBO.Item(itemCode);
    }
}

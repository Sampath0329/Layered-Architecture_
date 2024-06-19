package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.dao.Custome.Impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.Custome.Impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.dao.Custome.OrderDAO;
import com.example.layeredarchitecture.dao.Custome.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderBOImpl implements OrderBO{

    OrderDAO orderDAO = new OrderDAOImpl();
    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
    @Override
    public String getNewOrderId() throws SQLException, ClassNotFoundException {

        return orderDAO.getNewId();

    }
    @Override
    public boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {

       return orderDAO.save(orderDTO);

    }
    @Override
    public boolean existOrder(String orderId) throws SQLException, ClassNotFoundException {

        return orderDAO.exist(orderId);

    }
    @Override
    public boolean saveOrderDetail(OrderDetailDTO detail) throws SQLException, ClassNotFoundException {

        return orderDetailsDAO.save(detail);
    }
    @Override
    public boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException {return false;}
    @Override
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {return null;}
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {}
}

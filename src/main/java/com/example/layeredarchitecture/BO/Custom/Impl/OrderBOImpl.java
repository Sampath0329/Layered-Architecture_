package com.example.layeredarchitecture.BO.Custom.Impl;

import com.example.layeredarchitecture.BO.Custom.CustomerBO;
import com.example.layeredarchitecture.BO.Custom.ItemBO;
import com.example.layeredarchitecture.BO.Custom.OrderBO;
import com.example.layeredarchitecture.dao.Custome.Impl.OrderDAOImpl;
import com.example.layeredarchitecture.dao.Custome.Impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.dao.Custome.OrderDAO;
import com.example.layeredarchitecture.dao.Custome.OrderDetailsDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderBOImpl implements OrderBO {

    OrderDAO orderDAO = new OrderDAOImpl();
    ItemBO itemBO = new ItemBOImpl();

    CustomerBO customerBO = new CustomerBOImpl();

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
    public ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException {
        return orderDAO.getAll();

    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {}

    @Override
    public OrderDTO getOrder(String newValue) throws SQLException, ClassNotFoundException {
        return orderDAO.getOrder(newValue);
    }

    @Override
    public ArrayList<OrderDetailDTO> getAllOderDetails(String newValue) throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.getAllOrderDetails(newValue);
    }

    @Override
    public boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) {

        /*Transaction*/
        try {
            Connection connection = DBConnection.getDbConnection().getConnection();

            /*if order id already exist*/
            if (existOrder(orderId)){
                return false;
            }

            connection.setAutoCommit(false);

            if (!(saveOrder(new OrderDTO(orderId,orderDate,customerId)))){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }



            for (OrderDetailDTO detail : orderDetails) {

                if (!(saveOrderDetail(detail))) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

//                //Search & Update Item

                ItemDTO item = findItem(detail.getItemCode());
                item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                if (!(itemBO.updateItem(new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand())))) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }

            }

            connection.commit();
            connection.setAutoCommit(true);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerBO.existCustomer(id);
    }

    @Override
    public CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerBO.getCustomer(id);
    }

    @Override
    public boolean existItem(String itemCode) {
        return existItem(itemCode);
    }

    @Override
    public ItemDTO getItem(String itemCode) throws SQLException, ClassNotFoundException {
        return itemBO.Item(itemCode);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {
        return customerBO.getAllCustomer();
    }

    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {
        return itemBO.getAllItems();
    }

    public ItemDTO findItem(String code) {
        try {

            return itemBO.Item(code);

        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

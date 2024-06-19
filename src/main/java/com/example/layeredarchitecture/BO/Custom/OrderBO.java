package com.example.layeredarchitecture.BO.Custom;

import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrderBO {
     String getNewOrderId() throws SQLException, ClassNotFoundException;
     boolean saveOrder(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
     boolean existOrder(String orderId) throws SQLException, ClassNotFoundException ;
     boolean saveOrderDetail(OrderDetailDTO detail) throws SQLException, ClassNotFoundException ;
     boolean update(OrderDTO orderDTO) throws SQLException, ClassNotFoundException;
     ArrayList<OrderDTO> getAll() throws SQLException, ClassNotFoundException;
     void delete(String id) throws SQLException, ClassNotFoundException ;
     OrderDTO getOrder(String newValue) throws SQLException, ClassNotFoundException;

     ArrayList<OrderDetailDTO> getAllOderDetails(String newValue) throws SQLException, ClassNotFoundException;

     boolean saveOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails);

     boolean existCustomer(String id) throws SQLException, ClassNotFoundException;

     CustomerDTO getCustomer(String id) throws SQLException, ClassNotFoundException;

     boolean existItem(String itemCode);

     ItemDTO getItem(String itemCode) throws SQLException, ClassNotFoundException;

     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException;

     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException;

}

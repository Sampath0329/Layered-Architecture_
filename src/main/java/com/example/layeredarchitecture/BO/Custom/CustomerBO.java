package com.example.layeredarchitecture.BO.Custom;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerBO {
     ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException ;

     boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;


     boolean existCustomer(String id) throws SQLException, ClassNotFoundException ;

     boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException ;

     void deleteCustomer(String id) throws SQLException, ClassNotFoundException ;

     String getNewCustomerId() throws SQLException, ClassNotFoundException ;

     CustomerDTO getCustomer(String newValue) throws SQLException, ClassNotFoundException ;
}

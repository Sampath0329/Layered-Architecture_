package com.example.layeredarchitecture.dao;

import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;

public interface CustomerDAO extends CrudDAO<CustomerDTO>{

    public CustomerDTO getCustomer(String newValue)throws SQLException, ClassNotFoundException;
}

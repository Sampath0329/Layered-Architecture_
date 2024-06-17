package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.dao.CustomerDAO;
import com.example.layeredarchitecture.dao.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl {

    CustomerDAO customerDAO = new CustomerDAOImpl();
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {


        return customerDAO.getAll();
    }

    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);

    }


    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {

        return customerDAO.exist(id);
    }

    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

        return customerDAO.save(customerDTO);
    }

    public void deleteexistCustomer(String id) throws SQLException, ClassNotFoundException {

        customerDAO.delete(id);

    }

    public String getCurrentCustomerId() throws SQLException, ClassNotFoundException {

        return customerDAO.getCurrentId();
    }

    public CustomerDTO getCustomer(String newValue) throws SQLException, ClassNotFoundException {

        return customerDAO.getCustomer(newValue);

    }

}

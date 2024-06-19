package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.dao.Custome.CustomerDAO;
import com.example.layeredarchitecture.dao.Custome.Impl.CustomerDAOImpl;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO{

    CustomerDAO customerDAO = new CustomerDAOImpl();
    @Override
    public ArrayList<CustomerDTO> getAllCustomer() throws SQLException, ClassNotFoundException {


        return customerDAO.getAll();
    }
    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return customerDAO.update(customerDTO);

    }

    @Override
    public boolean existCustomer(String id) throws SQLException, ClassNotFoundException {

        return customerDAO.exist(id);
    }
    @Override
    public boolean saveCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException {

        return customerDAO.save(customerDTO);
    }
    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException {

        customerDAO.delete(id);

    }
    @Override
    public String getNewCustomerId() throws SQLException, ClassNotFoundException {

        return customerDAO.getNewId();
    }
    @Override
    public CustomerDTO getCustomer(String newValue) throws SQLException, ClassNotFoundException {

        return customerDAO.getCustomer(newValue);

    }

}

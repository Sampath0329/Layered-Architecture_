package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.dao.ItemDAOImpl;
import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl {
    ItemDAO itemDAO = new ItemDAOImpl();
    public String getCurrentId() throws SQLException, ClassNotFoundException {

        return itemDAO.getCurrentId();
    }


    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return itemDAO.save(itemDTO);
    }


    public boolean existItem(String itemId) throws SQLException, ClassNotFoundException {

        return itemDAO.exist(itemId);
    }

    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {

        return itemDAO.getAll();
    }


    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }

    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {

       return itemDAO.update(item);
    }

    public ItemDTO Item(String newItemCode) throws SQLException, ClassNotFoundException {

       return itemDAO.Item(newItemCode);
    }

}

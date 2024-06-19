package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.dao.Custome.Impl.ItemDAOImpl;
import com.example.layeredarchitecture.dao.Custome.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{
    ItemDAO itemDAO = new ItemDAOImpl();
    @Override
    public String getNewItemId() throws SQLException, ClassNotFoundException {

        return itemDAO.getNewId();
    }
    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException {

        return itemDAO.save(itemDTO);
    }
    @Override
    public boolean existItem(String itemId) throws SQLException, ClassNotFoundException {

        return itemDAO.exist(itemId);
    }
    @Override
    public ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException {

        return itemDAO.getAll();
    }
    @Override
    public void deleteItem(String code) throws SQLException, ClassNotFoundException {
        itemDAO.delete(code);
    }
    @Override
    public boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException {

       return itemDAO.update(item);
    }
    @Override
    public ItemDTO Item(String newItemCode) throws SQLException, ClassNotFoundException {

       return itemDAO.Item(newItemCode);
    }

}

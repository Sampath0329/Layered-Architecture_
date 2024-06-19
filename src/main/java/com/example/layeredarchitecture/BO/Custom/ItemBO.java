package com.example.layeredarchitecture.BO.Custom;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
     String getNewItemId() throws SQLException, ClassNotFoundException;
     boolean saveItem(ItemDTO itemDTO) throws SQLException, ClassNotFoundException ;
     boolean existItem(String itemId) throws SQLException, ClassNotFoundException ;
     ArrayList<ItemDTO> getAllItems() throws SQLException, ClassNotFoundException ;
     void deleteItem(String code) throws SQLException, ClassNotFoundException ;
     boolean updateItem(ItemDTO item) throws SQLException, ClassNotFoundException;
     ItemDTO Item(String newItemCode) throws SQLException, ClassNotFoundException;
}

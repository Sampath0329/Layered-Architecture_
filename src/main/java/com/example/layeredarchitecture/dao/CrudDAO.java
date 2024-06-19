package com.example.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<C> {
    public  boolean  update(C c)throws SQLException, ClassNotFoundException;

    public ArrayList<C> getAll() throws SQLException, ClassNotFoundException;


    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public boolean save(C c) throws SQLException, ClassNotFoundException;

    public void delete(String id)throws SQLException, ClassNotFoundException;

    public String getNewId() throws SQLException, ClassNotFoundException;

}

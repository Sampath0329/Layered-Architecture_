package com.example.layeredarchitecture.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> {
    public  boolean  update(T c)throws SQLException, ClassNotFoundException;

    public ArrayList<T> getAll( ) throws SQLException, ClassNotFoundException;


    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public boolean save(T c) throws SQLException, ClassNotFoundException;

    public void delete(String id)throws SQLException, ClassNotFoundException;

    public String getNewId() throws SQLException, ClassNotFoundException;

}

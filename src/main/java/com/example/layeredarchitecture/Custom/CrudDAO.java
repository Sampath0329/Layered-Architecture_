package com.example.layeredarchitecture.Custom;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<C> {
    public  boolean  update(C c)throws SQLException, ClassNotFoundException;

    public ArrayList<C> getAll() throws SQLException, ClassNotFoundException;


    public boolean exist(String id) throws SQLException, ClassNotFoundException;

    public boolean save(C c) throws SQLException, ClassNotFoundException;

    public void delete(String id)throws SQLException, ClassNotFoundException;

    public String getCurrentId() throws SQLException, ClassNotFoundException;

}

package lk.ijse.RanasingheCinnamon.dao;

import java.sql.SQLException;

public interface CrudDAO< T , ID> extends SuperDAO{
    public boolean save(T deliveries) throws SQLException, ClassNotFoundException;

    public T search(ID id) throws SQLException, ClassNotFoundException;

    public boolean delete(ID Id) throws SQLException, ClassNotFoundException;

    public boolean update(T deliveries) throws SQLException, ClassNotFoundException;
}

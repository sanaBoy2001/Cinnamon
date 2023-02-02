package lk.ijse.RanasingheCinnamon.dao;

import java.sql.SQLException;

public interface CrudDAO< T , ID> {
    public boolean save(T deliveries) throws SQLException, ClassNotFoundException;

    public T search(ID id) throws SQLException, ClassNotFoundException;

    public void delete(ID Id) throws SQLException, ClassNotFoundException;

    public void update(T deliveries) throws SQLException, ClassNotFoundException;
}

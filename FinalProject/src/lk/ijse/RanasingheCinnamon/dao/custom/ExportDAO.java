package lk.ijse.RanasingheCinnamon.dao.custom;

import lk.ijse.RanasingheCinnamon.dao.CrudDAO;
import lk.ijse.RanasingheCinnamon.entity.Export;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExportDAO extends CrudDAO<Export,String> {

    ArrayList<String> loadStockIds() throws SQLException, ClassNotFoundException;
}

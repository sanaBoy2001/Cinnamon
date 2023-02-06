package lk.ijse.RanasingheCinnamon.bo.custom;

import lk.ijse.RanasingheCinnamon.bo.SuperBO;
import lk.ijse.RanasingheCinnamon.dto.ExportDTO;
import lk.ijse.RanasingheCinnamon.entity.Export;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ExportBO extends SuperBO {

    boolean saveExport(ExportDTO exportDTO) throws SQLException, ClassNotFoundException;

    ExportDTO searchExport(String s) throws SQLException, ClassNotFoundException;

    boolean deleteExport(String Id) throws SQLException, ClassNotFoundException;

    boolean updateExport(ExportDTO exportDTO) throws SQLException, ClassNotFoundException;

    ArrayList<String> loadStockIds() throws SQLException, ClassNotFoundException;

}

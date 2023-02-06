package lk.ijse.RanasingheCinnamon.bo.custom.impl;

import lk.ijse.RanasingheCinnamon.bo.custom.ExportBO;
import lk.ijse.RanasingheCinnamon.dao.DAOFactory;
import lk.ijse.RanasingheCinnamon.dao.custom.EmployeeDAO;
import lk.ijse.RanasingheCinnamon.dao.custom.ExportDAO;
import lk.ijse.RanasingheCinnamon.dto.EmployeeDTO;
import lk.ijse.RanasingheCinnamon.dto.ExportDTO;
import lk.ijse.RanasingheCinnamon.entity.Export;

import java.sql.SQLException;
import java.util.ArrayList;

public class ExportBOImpl implements ExportBO {


    ExportDAO exportDAO = (ExportDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EXPORT);
    @Override
    public boolean saveExport(ExportDTO exportDTO) throws SQLException, ClassNotFoundException {
        return exportDAO.save(new Export(exportDTO.getId(),exportDTO.getDate(),exportDTO.getLocation(),exportDTO.getStatus()));
    }

    @Override
    public ExportDTO searchExport(String s) throws SQLException, ClassNotFoundException {
       Export export = exportDAO.search(s);
        return new ExportDTO(export.getEmployeeId(),export.getDate(),export.getCountry(),export.getStatus());
    }

    @Override
    public boolean deleteExport(String Id) throws SQLException, ClassNotFoundException {
        return exportDAO.delete(Id);
    }

    @Override
    public boolean updateExport(ExportDTO exportDTO) throws SQLException, ClassNotFoundException {
        return exportDAO.update(new Export(exportDTO.getId(),exportDTO.getDate(),exportDTO.getLocation(),exportDTO.getStatus()));
    }

    @Override
    public ArrayList<String> loadStockIds() throws SQLException, ClassNotFoundException {
        return exportDAO.loadStockIds();
    }
}

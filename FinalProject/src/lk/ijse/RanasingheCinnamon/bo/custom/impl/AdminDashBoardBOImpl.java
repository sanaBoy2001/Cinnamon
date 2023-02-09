package lk.ijse.RanasingheCinnamon.bo.custom.impl;

import lk.ijse.RanasingheCinnamon.bo.custom.AdminDashBoardBO;
import lk.ijse.RanasingheCinnamon.dao.DAOFactory;
import lk.ijse.RanasingheCinnamon.dao.custom.PlaceOrderDAO;

import java.sql.SQLException;

public class AdminDashBoardBOImpl implements AdminDashBoardBO {

    PlaceOrderDAO placeOrderDAO = (PlaceOrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PLACEORDER);

    @Override
    public int allCustomers() throws SQLException, ClassNotFoundException {

        return placeOrderDAO.customerCount();
    }
}

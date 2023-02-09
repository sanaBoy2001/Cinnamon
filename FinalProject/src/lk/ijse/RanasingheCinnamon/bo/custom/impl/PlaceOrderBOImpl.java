package lk.ijse.RanasingheCinnamon.bo.custom.impl;

import lk.ijse.RanasingheCinnamon.bo.custom.PlaceOrderBO;
import lk.ijse.RanasingheCinnamon.dao.DAOFactory;
import lk.ijse.RanasingheCinnamon.dao.custom.OrderDetailDAO;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.OrdersDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.PaymentsDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.PlaceOrderDAOImpl;
import lk.ijse.RanasingheCinnamon.db.DBConnection;
import lk.ijse.RanasingheCinnamon.dto.PlaceOrderDTO;

import java.sql.SQLException;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDetailDAO orderDetailDAO = (OrderDetailDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);
    public boolean orderPlace(PlaceOrderDTO placeOrder) throws SQLException, ClassNotFoundException {
        try {
            DBConnection.getInstance().getConnection().setAutoCommit(false);
            boolean add = PlaceOrderDAOImpl.addCustomer(placeOrder);
            if (add) {
                boolean isadd = OrdersDAOImpl.addOrder(placeOrder);
                if (isadd) {
                    boolean pay = PaymentsDAOImpl.addTotal(placeOrder);
                    if (pay) {
//                        boolean Details = OrderDetailDAOImpl.detail(placeOrder);
                        boolean Details = orderDetailDAO.detail(placeOrder);
                        if (Details) {
                            DBConnection.getInstance().getConnection().commit();
                            return true;
                        }
                    }
                    DBConnection.getInstance().getConnection().rollback();
                    return false;
                }

            }

        } finally {
            DBConnection.getInstance().getConnection().setAutoCommit(true);
        }
        return false;
    }
}

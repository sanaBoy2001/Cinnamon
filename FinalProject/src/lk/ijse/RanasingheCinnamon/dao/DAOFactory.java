package lk.ijse.RanasingheCinnamon.dao;

import lk.ijse.RanasingheCinnamon.dao.custom.impl.DeliveriesDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.EmployeeDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.ExportDAOImpl;
import lk.ijse.RanasingheCinnamon.dao.custom.impl.OrderDetailDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){

    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory == null){
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        DELIVERIES,EMPLOYEE,EXPORT,ORDERDETAIL,ORDERS,PAYMENTS,PLACEORDER,REGISTER,STOCK,SUPPLIER,VEHICLES
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types){
            case DELIVERIES:
                return new DeliveriesDAOImpl();
            case EMPLOYEE:
                return new EmployeeDAOImpl();
            case EXPORT:
                return new ExportDAOImpl();
            case ORDERDETAIL:
                return new OrderDetailDAOImpl();

            default:
                return null;
        }
    }
}

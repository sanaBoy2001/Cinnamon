package lk.ijse.RanasingheCinnamon.dao;

import lk.ijse.RanasingheCinnamon.dao.custom.impl.DeliveriesDAOImpl;

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

            default:
                return null;
        }
    }
}

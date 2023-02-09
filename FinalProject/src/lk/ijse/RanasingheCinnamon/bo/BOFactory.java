package lk.ijse.RanasingheCinnamon.bo;

import lk.ijse.RanasingheCinnamon.bo.custom.impl.DeliveriesBOImpl;
import lk.ijse.RanasingheCinnamon.bo.custom.impl.EmployeeBOImpl;
import lk.ijse.RanasingheCinnamon.bo.custom.impl.ExportBOImpl;
import lk.ijse.RanasingheCinnamon.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getBoFactory(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes{

        DELIVERIES,EMPLOYEE,EXPORT,ORDERDETAIL,ORDERS,PAYMENTS,PLACEORDER,REGISTER,STOCK,SUPPLIER,VEHICLES
    }

    public SuperBO getBO(BOTypes types){
        switch (types){
            case DELIVERIES:
                return new DeliveriesBOImpl();
            case EMPLOYEE:
               return new EmployeeBOImpl();
            case EXPORT:
                return new ExportBOImpl();
            case ORDERDETAIL:
                return new PlaceOrderBOImpl();

            default:
            return null;

        }
    }
}

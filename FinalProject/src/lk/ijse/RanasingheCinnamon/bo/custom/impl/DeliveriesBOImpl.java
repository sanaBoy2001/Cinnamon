package lk.ijse.RanasingheCinnamon.bo.custom.impl;

import lk.ijse.RanasingheCinnamon.bo.custom.DeliveriesBO;
import lk.ijse.RanasingheCinnamon.dao.DAOFactory;
import lk.ijse.RanasingheCinnamon.dao.custom.DeliveriesDAO;
import lk.ijse.RanasingheCinnamon.dao.custom.EmployeeDAO;
import lk.ijse.RanasingheCinnamon.dao.custom.OrdersDAO;
import lk.ijse.RanasingheCinnamon.dao.custom.VehiclesDAO;
import lk.ijse.RanasingheCinnamon.dto.DeliveriesDTO;
import lk.ijse.RanasingheCinnamon.entity.Transport;

import java.sql.SQLException;
import java.util.ArrayList;

public class DeliveriesBOImpl implements DeliveriesBO {

    DeliveriesDAO deliveriesDAO = (DeliveriesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.DELIVERIES);
    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);

    VehiclesDAO vehiclesDAO = (VehiclesDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.VEHICLES);

    OrdersDAO ordersDAO = (OrdersDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDERS);

    @Override
    public boolean addDeliver(DeliveriesDTO deliveriesDTO) throws SQLException, ClassNotFoundException {
        return deliveriesDAO.save(new Transport(deliveriesDTO.getId(),deliveriesDTO.getOrderId(),deliveriesDTO.getEmployeeId(),deliveriesDTO.getVehicleId(),deliveriesDTO.getDistance(),deliveriesDTO.getRoute()));
    }

    @Override
    public DeliveriesDTO seacrhDeliver(String id) throws SQLException, ClassNotFoundException {
        Transport transport = deliveriesDAO.search(id);
        return new DeliveriesDTO(transport.getEmployeeId(),transport.getOrderId(),transport.getEmployeeId(),transport.getVehicleId(),transport.getDistance(),transport.getRoute());
    }

    @Override
    public boolean deleteDeliver(String Id) throws SQLException, ClassNotFoundException {
        return deliveriesDAO.delete(Id);
    }

    @Override
    public boolean updateDeliver(DeliveriesDTO deliveriesDTO) throws SQLException, ClassNotFoundException {
        return deliveriesDAO.update(new Transport(deliveriesDTO.getId(),deliveriesDTO.getOrderId(),deliveriesDTO.getEmployeeId(),deliveriesDTO.getVehicleId(),deliveriesDTO.getDistance(),deliveriesDTO.getRoute()));
    }

    @Override
    public ArrayList loadEmployeeId() throws SQLException, ClassNotFoundException {
        return employeeDAO.loadEmployeeId();
    }

    @Override
    public ArrayList<String> loadVehicleId() throws SQLException, ClassNotFoundException {
        return vehiclesDAO.loadVehicleId();
    }

    @Override
    public ArrayList<String> loadOrderId() throws SQLException, ClassNotFoundException {
        return ordersDAO.loadOrderId();
    }


}

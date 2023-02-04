package lk.ijse.RanasingheCinnamon.bo.custom.impl;

import lk.ijse.RanasingheCinnamon.bo.custom.DeliveriesBO;
import lk.ijse.RanasingheCinnamon.dto.DeliveriesDTO;
import lk.ijse.RanasingheCinnamon.entity.Transport;

import java.sql.SQLException;

public class DeliveriesBOImpl implements DeliveriesBO {

    @Override
    public boolean addDeliver(DeliveriesDTO deliveriesDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public DeliveriesDTO seacrhDeliver(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean deleteDeliver(String Id) throws SQLException, ClassNotFoundException {

        return false;
    }

    @Override
    public boolean updateDeliver(Transport deliveries) throws SQLException, ClassNotFoundException {

        return false;
    }
}

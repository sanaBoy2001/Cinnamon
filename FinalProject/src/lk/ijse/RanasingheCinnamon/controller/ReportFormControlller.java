package lk.ijse.RanasingheCinnamon.controller;


import javafx.event.ActionEvent;
import lk.ijse.RanasingheCinnamon.db.DBConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.sql.SQLException;

public class ReportFormControlller {


    public void btnReportOnAction(ActionEvent actionEvent) {

        try {
            JasperDesign load = JRXmlLoader.load(getClass().getResourceAsStream("/lk/ijse/RanasingheCinnamon/view/Report/CustomerReport.jrxml"));
            JasperReport jasperReport = JasperCompileManager.compileReport(load);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        } catch (JRException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

      /*  try {
            JasperReport compiledReport = (JasperReport) JRLoader.loadObject(this.getClass().getResource("/lk/ijse/RanasingheCinnamon/view/Report/CustomerReport.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();} catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }*/
    }
}



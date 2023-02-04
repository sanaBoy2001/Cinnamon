package lk.ijse.RanasingheCinnamon.entity;

public class Transport {
    private String transportId;
    private String orderId;
    private String employeeId;
    private String vehicleId;
    private String distance;
    private String route;

    public Transport(String transportId, String orderId, String employeeId, String vehicleId, String distance, String route) {
        this.transportId = transportId;
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.vehicleId = vehicleId;
        this.distance = distance;
        this.route = route;
    }

    public String getTransportId() {
        return transportId;
    }

    public void setTransportId(String transportId) {
        this.transportId = transportId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }
}

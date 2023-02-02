package lk.ijse.RanasingheCinnamon.to;

public class Deliveries {
    private String id;
    private String distance;
    private String route;

    private String orderId;

    private String employeeId;
    private String vehicleId;

    public Deliveries(String id, String orderId, String employeeId, String vehicleId, String distance, String route) {
        this.id = id;
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.vehicleId = vehicleId;
        this.distance = distance;
        this.route = route;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}

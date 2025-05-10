package klu.modal;

import jakarta.persistence.*;

@Entity
@Table(name = "rides")
public class Ride {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String source;
    private String destination;
    private String vehicleType; // "Car", "Bike", or "None"
    private double distanceInKm;
    private double price;

    // Constructors
    public Ride() {}

    public Ride(String source, String destination, String vehicleType, double distanceInKm, double price) {
        this.source = source;
        this.destination = destination;
        this.vehicleType = vehicleType;
        this.distanceInKm = distanceInKm;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

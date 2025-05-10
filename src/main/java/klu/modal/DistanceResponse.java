package klu.modal;

public class DistanceResponse {
    private double distanceInKm;
    private double price;

    public DistanceResponse(double distanceInKm, double price) {
        this.distanceInKm = distanceInKm;
        this.price = price;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public double getPrice() {
        return price;
    }
}

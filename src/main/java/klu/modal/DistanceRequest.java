package klu.modal;

public class DistanceRequest {
    private String source;
    private String destination;

    // Constructors
    public DistanceRequest() {}

    public DistanceRequest(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    // Getters and Setters
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
}

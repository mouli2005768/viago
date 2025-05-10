package klu.service;

import klu.modal.Ride;
import klu.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.json.JSONObject;

@Service
public class RideService {

    @Autowired
    private RideRepository rideRepository;

    private final String GOOGLE_MAPS_API_KEY = "YOUR_GOOGLE_MAPS_API_KEY";

    public double calculateDistance(String source, String destination) {
        try {
            String url = String.format(
                "https://maps.googleapis.com/maps/api/distancematrix/json?origins=%s&destinations=%s&key=%s",
                source.replace(" ", "+"), destination.replace(" ", "+"), GOOGLE_MAPS_API_KEY
            );

            RestTemplate restTemplate = new RestTemplate();
            String response = restTemplate.getForObject(url, String.class);

            JSONObject json = new JSONObject(response);

            double distanceInMeters = json
                .getJSONArray("rows")
                .getJSONObject(0)
                .getJSONArray("elements")
                .getJSONObject(0)
                .getJSONObject("distance")
                .getDouble("value");

            return distanceInMeters / 1000.0; // convert to kilometers
        } catch (Exception e) {
            throw new RuntimeException("Failed to calculate distance: " + e.getMessage());
        }
    }

    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }
}

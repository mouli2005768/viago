package klu.service;

import klu.modal.DistanceRequest;
import klu.modal.DistanceResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

@Service
public class DistanceService {

    @Value("${google.api.key}")
    private String apiKey;

    public DistanceResponse calculateDistance(DistanceRequest request) {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" +
                request.getSource() + "&destinations=" + request.getDestination() +
                "&key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        try {
            com.fasterxml.jackson.databind.JsonNode root = 
                new com.fasterxml.jackson.databind.ObjectMapper().readTree(response);

            double distanceInMeters = root.get("rows").get(0).get("elements").get(0)
                .get("distance").get("value").asDouble();
            double distanceInKm = distanceInMeters / 1000.0;
            double price = distanceInKm * 3; // ₹3 per km

            return new DistanceResponse(distanceInKm, price);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse distance from Google API", e);
        }
    }
}

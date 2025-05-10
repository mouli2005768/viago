package klu.controller;

import klu.modal.Ride;
import klu.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rides")
public class RideController {

    @Autowired
    private RideService rideService;

    @GetMapping("/calculate")
    public double calculateDistance(
            @RequestParam String source,
            @RequestParam String destination) {
        return rideService.calculateDistance(source, destination);
    }

    @PostMapping("/save")
    public Ride saveRide(@RequestBody Ride ride) {
        return rideService.saveRide(ride);
    }
}

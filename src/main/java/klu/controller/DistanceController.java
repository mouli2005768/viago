package klu.controller;

import klu.modal.DistanceRequest;
import klu.modal.DistanceResponse;
import klu.service.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/distance")
@CrossOrigin(origins = "*") // Allow CORS if frontend is on a different port
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @PostMapping("/calculate")
    public DistanceResponse calculateDistance(@RequestBody DistanceRequest request) {
        return distanceService.calculateDistance(request);
    }
}

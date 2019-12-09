package com.xyinc.xyinc.resources;

import com.xyinc.xyinc.models.InterestPoint;
import com.xyinc.xyinc.models.POIdistance;
import com.xyinc.xyinc.repositories.InterestPointRepository;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/poi")
public class Resources {
    private static InterestPointRepository interestPointRepository;
    private Sort sort;

    public  Resources(InterestPointRepository interestPointRepository){
        this.interestPointRepository = interestPointRepository;
    }

    @GetMapping("")
    public List<InterestPoint> getAll() {
        return interestPointRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<InterestPoint> putInterestPoint(@Valid @RequestBody InterestPoint interestPoint){
        if (StringUtils.isEmpty(interestPoint.name) ||
                interestPoint.point_x < 0 ||
                interestPoint.point_y < 0)
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        interestPointRepository.save(interestPoint);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "findnearest", method = RequestMethod.POST)
    public ResponseEntity<List<InterestPoint>> findNearest(@Valid @RequestBody POIdistance poiDistance){
        if (poiDistance.max_distance < 0)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok().body(interestPointRepository.findAll().stream()
                .filter(p -> p.calculateDistance(poiDistance.point_x, poiDistance.point_y) <= poiDistance.max_distance)
                .collect(Collectors.toList()));
    }
}

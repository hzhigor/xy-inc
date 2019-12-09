package com.xyinc.xyinc.repositories;

import com.xyinc.xyinc.models.InterestPoint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InterestPointRepository extends MongoRepository<InterestPoint, String> {
}

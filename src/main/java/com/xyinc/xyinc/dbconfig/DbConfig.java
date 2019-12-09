package com.xyinc.xyinc.dbconfig;

import com.xyinc.xyinc.models.InterestPoint;
import com.xyinc.xyinc.repositories.InterestPointRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = InterestPointRepository.class)
public class DbConfig {
    @Bean
    CommandLineRunner commandLineRunner(InterestPointRepository interestPointRepository) {
        return strings -> {
            interestPointRepository.save(new InterestPoint("Lanchonete",27,12));
            interestPointRepository.save(new InterestPoint("Posto",31,18));
            interestPointRepository.save(new InterestPoint("Joalheria",15,12));
            interestPointRepository.save(new InterestPoint("Floricultura",19,21));
            interestPointRepository.save(new InterestPoint("Pub",12,8));
            interestPointRepository.save(new InterestPoint("Supermercado",23,6));
            interestPointRepository.save(new InterestPoint("Churrascaria",28,2));
        };
    }
}

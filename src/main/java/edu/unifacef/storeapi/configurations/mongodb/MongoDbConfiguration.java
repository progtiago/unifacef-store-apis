package edu.unifacef.storeapi.configurations.mongodb;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = {"edu.unifacef.storeapi.gateways.outputs.mongodb"})
public class MongoDbConfiguration {}

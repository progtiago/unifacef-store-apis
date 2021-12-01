package edu.unifacef.storeapi.gateways.outputs.mongodb.repositories;

import edu.unifacef.storeapi.gateways.outputs.mongodb.documents.StoreProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StoreProductRepository extends MongoRepository<StoreProductDocument, String> {
}

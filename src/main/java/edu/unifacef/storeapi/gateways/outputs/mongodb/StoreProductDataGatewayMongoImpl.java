package edu.unifacef.storeapi.gateways.outputs.mongodb;

import edu.unifacef.storeapi.domains.StoreProduct;
import edu.unifacef.storeapi.gateways.outputs.StoreProductDataGateway;
import edu.unifacef.storeapi.gateways.outputs.mongodb.documents.StoreProductDocument;
import edu.unifacef.storeapi.gateways.outputs.mongodb.repositories.StoreProductRepository;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreProductDataGatewayMongoImpl implements StoreProductDataGateway {

  private final StoreProductRepository storeProductRepository;

  @Override
  public StoreProduct save(final StoreProduct storeProduct) {
    if(Objects.isNull(storeProduct.getCreatedDate())) {
      storeProduct.setCreatedDate(LocalDateTime.now());
    }
    return storeProductRepository.save(new StoreProductDocument(storeProduct)).toDomain();
  }

  @Override
  public Optional<StoreProduct> findByCode(final String code) {
    return storeProductRepository.findById(code).map(StoreProductDocument::toDomain);
  }

  @Override
  public Page<StoreProduct> findByPage(final Pageable pageable) {
    return storeProductRepository.findAll(pageable).map(StoreProductDocument::toDomain);
  }
}

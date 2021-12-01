package edu.unifacef.storeapi.usecases;

import edu.unifacef.storeapi.domains.StoreProduct;
import edu.unifacef.storeapi.gateways.outputs.StoreProductDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindStoreProducts {

  private final StoreProductDataGateway storeProductDataGateway;

  public Page<StoreProduct> execute(final Pageable pageable) {
    log.info("Find storeProducts. Page: {}, Size: {}", pageable.getPageNumber(), pageable.getPageSize());
    return storeProductDataGateway.findByPage(pageable);
  }
}

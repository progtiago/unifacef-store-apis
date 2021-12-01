package edu.unifacef.storeapi.gateways.outputs;

import edu.unifacef.storeapi.domains.StoreProduct;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StoreProductDataGateway {

  StoreProduct save(StoreProduct storeProduct);

  Optional<StoreProduct> findByCode(String code);

  Page<StoreProduct> findByPage(Pageable pageable);
}

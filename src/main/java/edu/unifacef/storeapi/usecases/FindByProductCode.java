package edu.unifacef.storeapi.usecases;

import static edu.unifacef.storeapi.exceptions.MessageKey.STORE_PRODUCT_NOT_FOUND;

import edu.unifacef.storeapi.domains.StoreProduct;
import edu.unifacef.storeapi.exceptions.NotFoundException;
import edu.unifacef.storeapi.gateways.outputs.StoreProductDataGateway;
import edu.unifacef.storeapi.utils.MessageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FindByProductCode {

  private final StoreProductDataGateway storeProductDataGateway;
  private final MessageUtils messageUtils;

  public StoreProduct execute(final String code) {
    log.info("Find storeProduct. Product code: {}", code);
    return storeProductDataGateway.findByCode(code).orElseThrow(
        () -> new NotFoundException(messageUtils.getMessage(STORE_PRODUCT_NOT_FOUND, code)));
  }
}

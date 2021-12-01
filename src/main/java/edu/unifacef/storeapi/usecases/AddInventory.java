package edu.unifacef.storeapi.usecases;

import edu.unifacef.storeapi.domains.Inventory;
import edu.unifacef.storeapi.domains.StoreProduct;
import edu.unifacef.storeapi.gateways.outputs.StoreProductDataGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AddInventory {

  private final StoreProductDataGateway storeProductDataGateway;

  public void execute(final String productCode, final Inventory inventory) {
    log.info("Adding inventory. Product code: {}", productCode);

    StoreProduct storeProduct = storeProductDataGateway
        .findByCode(productCode).orElse(new StoreProduct(productCode));
    storeProduct.setInventory(inventory);
    storeProductDataGateway.save(storeProduct);
  }
}

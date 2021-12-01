package edu.unifacef.storeapi.gateways.inputs.http.responses;

import static java.util.Optional.ofNullable;

import edu.unifacef.storeapi.domains.StoreProduct;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class StoreProductResponse implements Serializable {

  private static final long serialVersionUID = 2433564720627372962L;

  private String productCode;
  private ProductResponse product;
  private PriceResponse price;
  private InventoryResponse inventory;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public StoreProductResponse(final StoreProduct storeProduct) {
    this.productCode = storeProduct.getProductCode();
    this.product = ofNullable(storeProduct.getProduct()).map(ProductResponse::new).orElse(null);
    this.price = ofNullable(storeProduct.getPrice()).map(PriceResponse::new).orElse(null);
    this.inventory = ofNullable(storeProduct.getInventory()).map(InventoryResponse::new).orElse(null);
    this.createdDate = storeProduct.getCreatedDate();
    this.lastModifiedDate = storeProduct.getLastModifiedDate();
  }
}

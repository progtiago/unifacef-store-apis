package edu.unifacef.storeapi.gateways.inputs.http.responses;

import static java.util.Optional.ofNullable;

import edu.unifacef.storeapi.domains.StoreProduct;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class StoreProductResponse implements Serializable {

  private static final long serialVersionUID = 2433564720627372962L;

  @ApiModelProperty(position = 1)
  private String productCode;

  @ApiModelProperty(position = 2)
  private ProductResponse product;

  @ApiModelProperty(position = 3)
  private PriceResponse price;

  @ApiModelProperty(position = 4)
  private InventoryResponse inventory;

  @ApiModelProperty(position = 5)
  private LocalDateTime createdDate;

  @ApiModelProperty(position = 6)
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

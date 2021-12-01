package edu.unifacef.storeapi.domains;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreProduct {

  private String productCode;
  private Product product;
  private Price price;
  private Inventory inventory;
  private LocalDateTime createdDate;
  private LocalDateTime lastModifiedDate;

  public StoreProduct(final String productCode) {
    this.productCode = productCode;
  }

}

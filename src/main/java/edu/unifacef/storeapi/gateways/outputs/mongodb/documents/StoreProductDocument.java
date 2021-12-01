package edu.unifacef.storeapi.gateways.outputs.mongodb.documents;

import static java.util.Optional.ofNullable;

import edu.unifacef.storeapi.domains.StoreProduct;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("storeProducts")
public class StoreProductDocument {

  @Id
  private String id;
  private ProductDocument product;
  private PriceDocument price;
  private InventoryDocument inventory;
  private LocalDateTime createdDate;
  @LastModifiedDate
  private LocalDateTime lastModifiedDate;

  public StoreProductDocument(final StoreProduct storeProduct) {
    this.id = storeProduct.getProductCode();
    this.product = ofNullable(storeProduct.getProduct())
        .map(ProductDocument::new).orElse(null);
    this.price = ofNullable(storeProduct.getPrice())
        .map(PriceDocument::new).orElse(null);
    this.inventory = ofNullable(storeProduct.getInventory())
        .map(InventoryDocument::new).orElse(null);
    this.createdDate = storeProduct.getCreatedDate();
    this.lastModifiedDate = storeProduct.getLastModifiedDate();
  }

  public StoreProduct toDomain() {
    return StoreProduct.builder()
        .productCode(this.id)
        .product(ofNullable(this.product).map(ProductDocument::toDomain).orElse(null))
        .price(ofNullable(this.price).map(PriceDocument::toDomain).orElse(null))
        .inventory(ofNullable(this.inventory).map(InventoryDocument::toDomain).orElse(null))
        .createdDate(this.createdDate)
        .lastModifiedDate(this.lastModifiedDate)
        .build();
  }
}

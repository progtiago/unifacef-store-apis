package edu.unifacef.storeapi.gateways.outputs.mongodb.documents;

import edu.unifacef.storeapi.domains.Price;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PriceDocument {

  private Double from;
  private Double to;

  public PriceDocument(final Price price) {
    this.from = price.getFrom();
    this.to = price.getTo();
  }

  public Price toDomain() {
    return Price.builder()
        .from(this.from)
        .to(this.to)
        .build();
  }
  
}

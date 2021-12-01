package edu.unifacef.storeapi.gateways.inputs.http.responses;

import edu.unifacef.storeapi.domains.Price;
import java.io.Serializable;
import lombok.Data;

@Data
public class PriceResponse implements Serializable {

  private static final long serialVersionUID = 3810524623457973402L;

  private Double from;
  private Double to;

  public PriceResponse(final Price price) {
    this.from = price.getFrom();
    this.to = price.getTo();
  }
}

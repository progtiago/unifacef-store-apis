package edu.unifacef.storeapi.gateways.inputs.http.responses;

import edu.unifacef.storeapi.domains.Inventory;
import java.io.Serializable;
import lombok.Data;

@Data
public class InventoryResponse implements Serializable {

  private static final long serialVersionUID = -4259934138115689433L;

  private Integer position;

  public InventoryResponse(final Inventory inventory) {
    this.position = inventory.getPosition();
  }
}

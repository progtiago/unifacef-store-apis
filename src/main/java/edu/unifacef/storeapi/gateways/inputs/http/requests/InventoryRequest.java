package edu.unifacef.storeapi.gateways.inputs.http.requests;

import edu.unifacef.storeapi.domains.Inventory;
import java.io.Serializable;
import lombok.Data;

@Data
public class InventoryRequest implements Serializable {

  private static final long serialVersionUID = -1943037968596384684L;

  private Integer position;

  public Inventory toDomain() {
    return Inventory.builder()
        .position(this.position)
        .build();
  }
}

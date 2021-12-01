package edu.unifacef.storeapi.gateways.outputs.mongodb.documents;

import edu.unifacef.storeapi.domains.Inventory;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class InventoryDocument {

  private Integer position;

  public InventoryDocument(final Inventory inventory) {
    this.position = inventory.getPosition();
  }

  public Inventory toDomain() {
    return Inventory.builder().position(this.position).build();
  }

}

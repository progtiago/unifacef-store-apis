package edu.unifacef.storeapi.usecases;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import edu.unifacef.storeapi.domains.Inventory;
import edu.unifacef.storeapi.domains.Price;
import edu.unifacef.storeapi.domains.StoreProduct;
import edu.unifacef.storeapi.gateways.outputs.StoreProductDataGateway;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AddInventoryTest {

  @InjectMocks
  private AddInventory addInventory;

  @Mock
  private StoreProductDataGateway storeProductDataGateway;

  @Test
  public void shouldCreateNewStoreProduct() {
    String productCode = "A10";
    Inventory inventory = Inventory.builder().position(1).build();
    StoreProduct expectedStoreProduct =
        StoreProduct.builder().productCode(productCode).inventory(inventory).build();

    when(storeProductDataGateway.findByCode(anyString())).thenReturn(Optional.empty());

    addInventory.execute(productCode, inventory);
    verify(storeProductDataGateway).save(expectedStoreProduct);
  }

  @Test
  public void shouldUpdateStoreProduct() {
    String productCode = "A10";
    Inventory inventory = Inventory.builder().position(1).build();
    StoreProduct preStoreProduct =
        StoreProduct.builder().productCode(productCode)
            .price(Price.builder().build()).build();

    StoreProduct expectedStoreProduct =
        StoreProduct.builder().productCode(productCode)
            .price(Price.builder().build())
            .inventory(inventory).build();

    when(storeProductDataGateway.findByCode(anyString()))
        .thenReturn(Optional.of(preStoreProduct));

    addInventory.execute(productCode, inventory);
    verify(storeProductDataGateway).save(expectedStoreProduct);
  }
}


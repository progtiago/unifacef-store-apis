package edu.unifacef.storeapi.gateways.inputs.http;

import edu.unifacef.storeapi.domains.StoreProduct;
import edu.unifacef.storeapi.gateways.inputs.http.requests.InventoryRequest;
import edu.unifacef.storeapi.gateways.inputs.http.requests.PriceRequest;
import edu.unifacef.storeapi.gateways.inputs.http.requests.ProductRequest;
import edu.unifacef.storeapi.gateways.inputs.http.responses.ListResponse;
import edu.unifacef.storeapi.gateways.inputs.http.responses.StoreProductResponse;
import edu.unifacef.storeapi.usecases.AddInventory;
import edu.unifacef.storeapi.usecases.AddPrice;
import edu.unifacef.storeapi.usecases.AddProduct;
import edu.unifacef.storeapi.usecases.FindByProductCode;
import edu.unifacef.storeapi.usecases.FindStoreProducts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/products")
public class StoreController {

  private final AddProduct addProduct;
  private final AddPrice addPrice;
  private final AddInventory addInventory;
  private final FindByProductCode findByProductCode;
  private final FindStoreProducts findStoreProducts;

  @PostMapping(path = "/{productCode}")
  public void addProduct(@PathVariable final String productCode,
                         @RequestBody final ProductRequest request) {
    addProduct.execute(productCode, request.toDomain());
  }

  @PostMapping(path = "/{productCode}/prices")
  public void addPrice(@PathVariable final String productCode,
                       @RequestBody final PriceRequest request) {
    addPrice.execute(productCode, request.toDomain());
  }

  @PostMapping(path = "/{productCode}/inventories")
  public void addInventory(@PathVariable final String productCode,
                           @RequestBody final InventoryRequest request) {
    addInventory.execute(productCode, request.toDomain());
  }

  @GetMapping(path = "/{productCode}")
  public StoreProductResponse find(@PathVariable final String productCode) {
    StoreProduct storeProduct = findByProductCode.execute(productCode);
    return new StoreProductResponse(storeProduct);
  }

  @GetMapping
  public ListResponse<StoreProductResponse> findByPage(@RequestParam(defaultValue = "0") final Integer page,
                                                  @RequestParam(defaultValue = "20") final Integer size) {
    Page<StoreProductResponse> productPage =
        findStoreProducts.execute(PageRequest.of(page, size)).map(StoreProductResponse::new);
    return new ListResponse<>(productPage);
  }
}

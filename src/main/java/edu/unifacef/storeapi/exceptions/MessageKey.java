package edu.unifacef.storeapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MessageKey {

  STORE_PRODUCT_NOT_FOUND("store.product.not.found");

  private String key;

}

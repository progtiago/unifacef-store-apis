package edu.unifacef.storeapi.domains;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {

  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<Attribute> attributes;

}

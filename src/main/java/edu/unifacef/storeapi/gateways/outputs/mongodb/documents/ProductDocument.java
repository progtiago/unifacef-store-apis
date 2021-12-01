package edu.unifacef.storeapi.gateways.outputs.mongodb.documents;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.storeapi.domains.Product;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDocument {

  private String name;
  private String description;
  private String brand;
  private List<String> images;
  private List<AttributeDocument> attributes;

  public ProductDocument(final Product product) {
    this.name = product.getName();
    this.description = product.getDescription();
    this.brand = product.getBrand();
    this.images = product.getImages();
    this.attributes = emptyIfNull(product.getAttributes())
        .stream().map(AttributeDocument::new).collect(toList());
  }

  public Product toDomain() {
    return Product.builder()
        .name(this.name)
        .description(this.description)
        .brand(this.brand)
        .images(this.images)
        .attributes(emptyIfNull(this.attributes).stream()
            .map(AttributeDocument::toDomain).collect(toList()))
        .build();
  }

}

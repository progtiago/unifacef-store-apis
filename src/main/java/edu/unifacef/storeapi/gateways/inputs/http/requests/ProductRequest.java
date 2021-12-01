package edu.unifacef.storeapi.gateways.inputs.http.requests;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

import edu.unifacef.storeapi.domains.Product;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
public class ProductRequest implements Serializable {

  private static final long serialVersionUID = -4089111392479104913L;

  @ApiModelProperty(position = 1)
  private String name;

  @ApiModelProperty(position = 2)
  private String description;

  @ApiModelProperty(position = 3)
  private String brand;

  @ApiModelProperty(position = 4)
  private List<String> images;

  @ApiModelProperty(position = 5)
  private List<AttributeRequest> attributes;

  public Product toDomain() {
    return Product.builder()
        .name(this.name)
        .description(this.description)
        .brand(this.brand)
        .images(this.images)
        .attributes(emptyIfNull(this.attributes).stream()
            .map(AttributeRequest::toDomain).collect(toList()))
        .build();
  }

}

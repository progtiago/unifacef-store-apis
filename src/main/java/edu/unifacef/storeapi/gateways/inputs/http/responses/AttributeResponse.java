package edu.unifacef.storeapi.gateways.inputs.http.responses;

import edu.unifacef.storeapi.domains.Attribute;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class AttributeResponse implements Serializable {

  private static final long serialVersionUID = 7808546186559340341L;

  @ApiModelProperty(position = 1)
  private String key;

  @ApiModelProperty(position = 2)
  private String value;

  public AttributeResponse(final Attribute attribute) {
    this.key = attribute.getKey();
    this.value = attribute.getValue();
  }

}

package edu.unifacef.storeapi.gateways.inputs.http.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ListResponse<T> implements Serializable {

    private static final long serialVersionUID = 7784952723804363766L;

  @ApiModelProperty(position = 1)
    private List<T> items;

  @ApiModelProperty(position = 2)
    private Integer page;

  @ApiModelProperty(position = 3)
    private Integer size;

  @ApiModelProperty(position = 4)
    private Integer totalPages;

  @ApiModelProperty(position = 5)
    private Long totalElements;

    public ListResponse(final Page<T> page) {
      items = page.getContent();
        this.page = page.getPageable().getPageNumber();
      size = page.getPageable().getPageSize();
      totalElements = page.getTotalElements();
      totalPages = page.getTotalPages();
    }
}

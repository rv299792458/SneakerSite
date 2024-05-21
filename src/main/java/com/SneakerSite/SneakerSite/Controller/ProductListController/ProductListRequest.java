package com.SneakerSite.SneakerSite.Controller.ProductListController;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class ProductListRequest {
    private String username;
    private int limit;
    private int offset;
    private FlowType flowtype;

}


enum FlowType{
    COUNT,LIST
}

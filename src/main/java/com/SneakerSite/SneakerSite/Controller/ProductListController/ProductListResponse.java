package com.SneakerSite.SneakerSite.Controller.ProductListController;

import com.SneakerSite.SneakerSite.Controller.DTO.ProductDTO;
import com.SneakerSite.SneakerSite.Controller.DTO.ProductSizeDTO;
import com.SneakerSite.SneakerSite.Models.ProductSizeCount;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.SneakerSite.SneakerSite.Models.Product;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ProductListResponse {
private long totalCount;
private List<ProductDTO> products;
//
//@Data
//static class ProductDTO{
//    private String productCode;
//    private String name;
//    private String productDetails;
//    private Double price;
//    private String priceUnit;
//    private Double discount;
//
//    List<ProductSizeCountDTO>productSizeCount;
//}
//
//@Data
//static class ProductSizeCountDTO{
//    private int productSize;
//    private int productCount;
//}
//

public static ProductListResponse buildCountFlow( long totalCount)
{
    ProductListResponse response = new ProductListResponse();
    response.setTotalCount(totalCount);
    return response;
}

public static ProductListResponse buildListFlow(List<Product> products) {
    ProductListResponse response = new ProductListResponse();
    List<ProductDTO> productDTOList = new ArrayList<>();
    for (Product p : products) {
        ProductDTO pdto = new ProductDTO();
        pdto.setProductCode(p.getProductCode());
        pdto.setName(p.getName());
        pdto.setProductDetails(p.getProductDetails());
        pdto.setPrice(p.getPrice());
        pdto.setPriceUnit(p.getPriceUnit());
        pdto.setDiscount(p.getDiscount());
        pdto.setProductImage(p.getProductImage());
        List<ProductSizeDTO> productSizeCountDTOList = new ArrayList<>();
//
        for (ProductSizeCount pc : p.getProductSizeCountList()) {
            ProductSizeDTO psDto = new ProductSizeDTO();
            psDto.setProductCount(pc.getProductCount());
            psDto.setProductSize(pc.getProductSize());
            productSizeCountDTOList.add(psDto);
        }
        pdto.setProductSizeCountList(productSizeCountDTOList);
        productDTOList.add(pdto);
    }

        response.setProducts(productDTOList);
        return response;
    }
}







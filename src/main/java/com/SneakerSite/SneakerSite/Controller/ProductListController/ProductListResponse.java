package com.SneakerSite.SneakerSite.Controller.ProductListController;

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
private List<Product> products;
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

public static ProductListResponse buildListFlow(List<Product> products)
{
    ProductListResponse response = new ProductListResponse();
//    List<ProductDTO>productDTOList = new ArrayList<>();
//    for(Product p : products)
//    {
//        ProductDTO pdto = new ProductDTO();
//        pdto.setProductCode(p.getProductCode());
//        pdto.setName(p.getName());
//        pdto.setProductDetails(p.getProductDetails());
//        pdto.setPrice(p.getPrice());
//        pdto.setPriceUnit(p.getPriceUnit());
//        pdto.setDiscount(p.getDiscount());
//        List<ProductSizeCountDTO>productSizeCountDTOList =  new ArrayList<>();
//
//        for(ProductSizeCount pc : p.getProductSizeCountList())
//        {
//            ProductSizeCountDTO psDto = new ProductSizeCountDTO();
//            psDto.setProductCount(pc.getProductCount());
//            psDto.setProductSize(pc.getProductSize());
//            productSizeCountDTOList.add(psDto);
//        }
//        pdto.setProductSizeCount(productSizeCountDTOList);
//        productDTOList.add(pdto);
//    }

    response.setProducts(products);
    return response;
}



}



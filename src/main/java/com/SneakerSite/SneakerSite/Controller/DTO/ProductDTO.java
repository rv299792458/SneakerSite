package com.SneakerSite.SneakerSite.Controller.DTO;

import com.SneakerSite.SneakerSite.Models.ProductSizeCount;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class ProductDTO {
    private String productCode;
    private String name;
    private String productDetails;
    private Double price;
    private String priceUnit;
    private Double discount;
    private String productImage;
    private List<ProductSizeDTO> productSizeCountList;
}

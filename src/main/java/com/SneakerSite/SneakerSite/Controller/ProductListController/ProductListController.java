package com.SneakerSite.SneakerSite.Controller.ProductListController;

import com.SneakerSite.SneakerSite.Controller.DTO.ProductDTO;
import com.SneakerSite.SneakerSite.Controller.RestApiResponse;
import com.SneakerSite.SneakerSite.Models.Product;
import com.SneakerSite.SneakerSite.Repository.ProductRepositry;
import com.SneakerSite.SneakerSite.Repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.SneakerSite.SneakerSite.Utils.SessionIdValidity.isValidSession;

@RestController
public class ProductListController {

    @Autowired
    private SessionRepository sessionRepo;

    @Autowired
    private ProductRepositry productRepo;
    @RequestMapping("/productList")
    public RestApiResponse fetchProductList(@CookieValue("sessionId") String sessionId , @RequestBody ProductListRequest productListRequest)
    {
        // sessionCheck
        if(!isValidSession(sessionId,productListRequest.getUsername(),sessionRepo))
        {
            return RestApiResponse.buildFail("107", "Session Expired");
        }

        ProductListResponse response;
        if(productListRequest.getFlowtype().name().equalsIgnoreCase("COUNT"))
        {
            long totalCount = productRepo.count();
            response = ProductListResponse.buildCountFlow(totalCount);
        }else{
            List<Product> products = (List)productRepo.findProductWithPagination(productListRequest.getLimit(), productListRequest.getOffset());
//            PageRequest pageRequest = PageRequest.of(1,1)
            response = ProductListResponse.buildListFlow(products);
        }

        return RestApiResponse.buildSuccess(response);
    }

}

package com.SneakerSite.SneakerSite.Controller.LoginController;


import com.SneakerSite.SneakerSite.Controller.MessageApiResponse;
import com.SneakerSite.SneakerSite.Controller.RestApiResponse;
import com.SneakerSite.SneakerSite.Models.UserAccount;
import com.SneakerSite.SneakerSite.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepo;
    @PostMapping("/login")
    public RestApiResponse Login(@RequestBody @Valid LoginRequest req)
    {

        try {
            UserAccount user = userRepo.findByUsername(req.getUsername());
            if(Objects.isNull(user))
            {
                return RestApiResponse.buildFail("104","User Not Found, Please SignUp");
            }

            return RestApiResponse.buildSuccess();
        }catch (Exception e)
        {
            return RestApiResponse.buildFail(new MessageApiResponse("101","Something went Wrong"));
        }


    }

}

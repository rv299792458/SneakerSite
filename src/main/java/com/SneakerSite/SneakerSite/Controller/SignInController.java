package com.SneakerSite.SneakerSite.Controller;

import com.SneakerSite.SneakerSite.Models.UserAccount;
import com.SneakerSite.SneakerSite.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
public class SignInController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/signup")
    public RestApiResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest)
    {
        try {
            List<UserAccount> existingByUserName =  userRepo.findByUsername(signUpRequest.getUsername());
            if(existingByUserName.size()>=1)
            {
                return RestApiResponse.buildFail(new MessageApiResponse("102","UserName Already Exist "));
            }

            List<UserAccount> existingByEmail =  userRepo.findByEmail(signUpRequest.getEmail());

            if(existingByEmail.size()>=1)
            {
                return RestApiResponse.buildFail(new MessageApiResponse("103","Email Already Used "));
            }

            UserAccount user = new UserAccount();
            user.setUsername(signUpRequest.getUsername());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(signUpRequest.getPassword());
            userRepo.save(user);

            return RestApiResponse.buildSuccess();

        }catch (Exception e)
        {
            return RestApiResponse.buildFail(new MessageApiResponse("101","Something went Wrong"));
        }

    }

}

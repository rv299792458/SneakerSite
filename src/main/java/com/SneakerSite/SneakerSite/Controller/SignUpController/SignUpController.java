package com.SneakerSite.SneakerSite.Controller.SignUpController;

import com.SneakerSite.SneakerSite.Controller.MessageApiResponse;
import com.SneakerSite.SneakerSite.Controller.RestApiResponse;
import com.SneakerSite.SneakerSite.Models.Session;
import com.SneakerSite.SneakerSite.Models.UserAccount;
import com.SneakerSite.SneakerSite.Repository.SessionRepository;
import com.SneakerSite.SneakerSite.Repository.UserRepository;
import com.SneakerSite.SneakerSite.Utils.PasswordEncoderUtil;
import com.SneakerSite.SneakerSite.Utils.RandomStringGenerated;
import jakarta.validation.Valid;
import org.hibernate.grammars.hql.HqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.SneakerSite.SneakerSite.Utils.PasswordEncoderUtil;

@RestController
public class SignUpController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private SessionRepository sessionRepo;

    @PostMapping("/signup")
    public RestApiResponse SignUp(@RequestBody @Valid SignUpRequest signUpRequest)
    {
        try {
            UserAccount existingByUserName =  userRepo.findByUsername(signUpRequest.getUsername());
            if(!Objects.isNull(existingByUserName))
            {
                return RestApiResponse.buildFail(new MessageApiResponse("102","UserName Already Exist "));
            }

            UserAccount existingByEmail =  userRepo.findByEmail(signUpRequest.getEmail());

            if(!Objects.isNull(existingByEmail))
            {
                return RestApiResponse.buildFail(new MessageApiResponse("103","Email Already Used "));
            }

            PasswordEncoderUtil ecp = new PasswordEncoderUtil();
            UserAccount user = new UserAccount();
            user.setUsername(signUpRequest.getUsername());
            user.setEmail(signUpRequest.getEmail());
            user.setPassword(ecp.encodePassword(signUpRequest.getPassword()));
            user.setPasswordSalt(ecp.getEncSalt());
            userRepo.save(user);

            return RestApiResponse.buildSuccess();

        }catch (Exception e)
        {
            return RestApiResponse.buildFail(new MessageApiResponse("101","Something went Wrong"));
        }

    }

}

package com.SneakerSite.SneakerSite.Controller.LoginController;


import com.SneakerSite.SneakerSite.Controller.MessageApiResponse;
import com.SneakerSite.SneakerSite.Controller.RestApiResponse;
import com.SneakerSite.SneakerSite.Models.Session;
import com.SneakerSite.SneakerSite.Models.UserAccount;
import com.SneakerSite.SneakerSite.Repository.SessionRepository;
import com.SneakerSite.SneakerSite.Repository.UserRepository;
import com.SneakerSite.SneakerSite.Utils.PasswordEncoderUtil;
import com.SneakerSite.SneakerSite.Utils.RandomStringGenerated;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

@RestController
public class LoginController {

    @Autowired
    private UserRepository userRepo;
    @Autowired
    private SessionRepository sessionRepo;
    @PostMapping("/login")
    public RestApiResponse Login(@RequestBody @Valid LoginRequest req, HttpServletResponse response)
    {
        try {
            UserAccount user = userRepo.findByUsername(req.getUsername());
            if(Objects.isNull(user))
            {
                return RestApiResponse.buildFail("104","User Not Found, Please SignUp");
            }

            Session session = sessionRepo.findByUsername(user.getUsername());

            if(Objects.isNull(session))
            {
                RandomStringGenerated rs = new RandomStringGenerated();
                session = new Session();
                String x = rs.randomString(15);
                session.setSessionToken(x);
                session.setLogInCount(1);
                session.setUsername(req.getUsername());
                session.setExpiryTime(LocalDateTime.now().plusHours(24));
                sessionRepo.save(session);
            }

            Cookie cookie = new Cookie("sessionId", session.getSessionToken());
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);

            PasswordEncoderUtil ecp = new PasswordEncoderUtil();
            ecp.setEncSalt(user.getPasswordSalt());
            String hashedPass = ecp.encodePassword(req.getPassword());
            if(hashedPass.equals(user.getPassword()))
            {
                return RestApiResponse.buildSuccess();
            }

            else
                return RestApiResponse.buildFail("105", "User Password is incorrect");
        }catch (Exception e)
        {
            return RestApiResponse.buildFail(new MessageApiResponse("101","Something went Wrong"));
        }


    }

}

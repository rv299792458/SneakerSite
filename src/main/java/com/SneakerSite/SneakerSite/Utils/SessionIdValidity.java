package com.SneakerSite.SneakerSite.Utils;

import com.SneakerSite.SneakerSite.Models.Session;
import com.SneakerSite.SneakerSite.Models.SessionStatus;
import com.SneakerSite.SneakerSite.Repository.SessionRepository;

import java.time.LocalDateTime;
import java.util.Objects;

public class SessionIdValidity {

    public static boolean isValidSession(String sessionToken , String username, SessionRepository sessionRepo)
    {
        Session session = sessionRepo.findByUsername(username);
        if(Objects.isNull(session))return false;

        if(session.getCreatedAt().plusDays(1).isAfter(LocalDateTime.now()))
        {
            session.setStatus(SessionStatus.EXPIRED);
            sessionRepo.save(session);
        }

        if(session.getStatus() == SessionStatus.EXPIRED)
            return false;

        if(session.getSessionToken().equals(sessionToken))
            return true;

        return false;
    }


}

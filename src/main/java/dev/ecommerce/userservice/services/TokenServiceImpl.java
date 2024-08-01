package dev.ecommerce.userservice.services;

import dev.ecommerce.userservice.models.Token;
import dev.ecommerce.userservice.models.User;
import dev.ecommerce.userservice.repositories.TokenRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {

    public TokenRepository tokenRepository;

    public TokenServiceImpl(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public Token createToken(User user) {
        String randomToken = RandomStringUtils.randomAlphabetic(128);
        Token token = new Token();

        LocalDateTime futureDateTime = LocalDateTime.now().plusDays(15);
        ZonedDateTime zonedDateTime = futureDateTime.atZone(ZoneId.systemDefault());

        token.setTokenValue(randomToken);
        token.setExpiryDate(Date.from(zonedDateTime.toInstant()));
        token.setUser(user);
        return tokenRepository.save(token);
    }
}

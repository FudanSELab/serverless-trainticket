package com.openfaas.function.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.openfaas.function.constant.InfoConstant;
import com.openfaas.function.dto.BasicAuthDto;
import com.openfaas.function.dto.TokenDto;
import com.openfaas.function.entity.User;
import com.openfaas.function.repository.UserRepository;
import com.openfaas.function.repository.UserRepositoryImpl;
import edu.fudan.common.util.mResponse;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fdse
 */

public class TokenServiceImpl implements TokenService {

    /**
     * token秘钥，请勿泄露，请勿随便修改 backups:JKKLJOoasdlfj
     */
    public static final String SECRET = "JKKLJOoasdlfj";
    /**
     * token 过期时间: 10天
     */
    public static final int calendarField = Calendar.DATE;
    public static final int calendarInterval = 10;
//    private JWTProvider jwtProvider;

    private UserRepository userRepository = new UserRepositoryImpl();


    @Override
    public mResponse getToken(BasicAuthDto dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();

        // verify username and password
        User user = userRepository.findByUsername(username);
        if (user == null)
            return new mResponse<>(0, InfoConstant.USER_NAME_NOT_FOUND_1, null);

        if (!user.getPassword().equals(password))
            return new mResponse<>(0, "Incorrect username or password.", null);


//        String token = jwtProvider.createToken(user);
        String token = createToken(user);
        return new mResponse<>(1, "login success", new TokenDto(user.getUserId(), username, token));
    }

    private String createToken(User user) {
        String user_id = user.getUserId().toString();

        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(calendarField, calendarInterval);
        Date expiresDate = nowTime.getTime();

        // header Map
        Map<String, Object> map = new HashMap<>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        // build token
        // param backups {iss:Service, aud:APP}
        String token = JWT.create().withHeader(map) // header
                .withClaim("iss", "Service") // payload
                .withClaim("aud", "APP").withClaim("user_id", null == user_id ? null : user_id.toString())
                .withIssuedAt(iatDate) // sign time
                .withExpiresAt(expiresDate) // expire time
                .sign(Algorithm.HMAC256(SECRET)); // signature

        return token;
    }
}

package auth.service;

import auth.dto.BasicAuthDto;
import edu.fudan.common.util.Response;
import org.springframework.http.HttpHeaders;

/**
 * @author fdse
 */
public interface TokenService {

    /**
     * get token by dto
     *
     * @param dto dto
     * @param  headers headers
     * @return Response
     */
    Response getToken(BasicAuthDto dto, HttpHeaders headers);


}

package framework.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import framework.core.security.model.AuthType;
import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends RuntimeException {
    private String requestedUrl;
    private AuthType type;
    private Object fieldValue;

    public UnauthorizedException() {

    }

    public UnauthorizedException(String requestedUrl, AuthType type) {
        super(String.format("%s not found with %s", requestedUrl, type.name()));
        this.requestedUrl = requestedUrl;
        this.type = type;
    }

}

package ru.rdm.core.security.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import ru.rdm.core.controller.method.auth.Check;
import ru.rdm.core.enums.Error;
import ru.rdm.core.exception.RdmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@RequiredArgsConstructor
public class RequestInterceptor implements HandlerInterceptor {

    private final Check check;

    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response
            , Object handler)
    {
        String access_token = request.getHeader("access_token");
        if (access_token == null || "".equals(access_token)){
            throw new RdmException(Error.INVALID_SESSION);
        }
        return check.checkSession(access_token);
    }
}

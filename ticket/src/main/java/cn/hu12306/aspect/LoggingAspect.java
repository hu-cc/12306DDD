package cn.hu12306.aspect;

import cn.hu12306.config.LoggingProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

/**
 * @author hcc
 */
@Slf4j
@Aspect
@Component
public class LoggingAspect {

    private final LoggingProperties loggingProperties;
    private final AntPathMatcher antPathMatcher;

    public LoggingAspect(LoggingProperties loggingProperties) {
        this.loggingProperties = loggingProperties;
        this.antPathMatcher = new AntPathMatcher();
    }

    @Before("execution(* cn.hu12306.web..*(..))")
    public void doBefore(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        if (shouldLog(request.getRequestURI())) {
            addRequestLog(request, joinPoint);
        }
    }

    public void addRequestLog(HttpServletRequest request, JoinPoint point) {
        log.info("{} {}, params: {}", request.getMethod(), request.getRequestURI(), point.getArgs());
    }

    private boolean shouldLog(String path) {
        return loggingProperties.getIncludePaths().stream().anyMatch(pattern -> antPathMatcher.match(pattern, path));
    }

}

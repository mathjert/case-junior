package no.sikt.caseoppgave.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(0)
@Component
public class RequestLoggerFilter implements Filter {

    private static Logger log = LoggerFactory.getLogger(RequestLoggerFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        String method = req.getMethod();
        String reqUrl = req.getRequestURL().toString();

        if (logDebug(req)) {
            log.debug(method + " - " + reqUrl);
        } else {
            log.info(method + " - " + reqUrl);
        }

        chain.doFilter(servletRequest, servletResponse);
    }

    private boolean logDebug(HttpServletRequest req) {
        return "OPTIONS".equals(req.getMethod());
    }
}

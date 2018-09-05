package IPINoteGods.IPINotes.Filter;

import org.springframework.stereotype.Component;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
* This filter allow CORS request for everyone
*/
@Component
public class CORSFilter implements Filter {

/**
* For each HTTP Response add CORS authorization
*
* @param req the request
* @param res the response
* @param chain the filterChain
*/
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
throws IOException, ServletException {
HttpServletResponse response = (HttpServletResponse) res;
response.setHeader("Access-Control-Allow-Origin", "*");
response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
response.setHeader("Access-Control-Max-Age", "3600");
response.setHeader("Access-Control-Allow-Headers", "accept,content-type,x-requested-with,nom,prenom,utilisateur,login,password");
chain.doFilter(req, res);
}

/**
* The initialization of the Filter (do nothing here)
*/
public void init(FilterConfig filterConfig) {
}

/**
* The destruction of the filter, (do nothing here)
*/
public void destroy() {
}

}
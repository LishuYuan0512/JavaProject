package filter;

import entity.Charity;
import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
/**
 * A servlet filter that checks if a user session contains a valid charity object.
 * It ensures that only authenticated charity users can access certain resources.
 */
@WebFilter(value = "/charity/safe/*")
public class CheckCharityFilter implements Filter {
    
        /**
     * Initializes the filter configuration.
     * This method is called once when the filter is first created.
     *
     * @param config The filter configuration.
     * @throws ServletException If an error occurs during initialization.
     */
    public void init(FilterConfig config) throws ServletException {
    }
    
        /**
     * Destroys the filter.
     * This method is called once when the filter is being taken out of service.
     */

    public void destroy() {
    }
    
        /**
     * Performs the filtering operation.
     * Checks if the session contains a charity object. If present, the request proceeds;
     * otherwise, the user is redirected to the login page.
     *
     * @param request  The ServletRequest object contains the client's request.
     * @param response The ServletResponse object contains the filter's response.
     * @param chain    The FilterChain allows the request to pass through the chain.
     * @throws ServletException If an error occurs during filtering.
     * @throws IOException      If an I/O error occurs during filtering.
     */

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Charity  charity = (Charity) session.getAttribute("charity");
        if (charity != null) {
            chain.doFilter(request, response);
        }else {
             // If charity is not present, redirect to login page
            res.sendRedirect(req.getContextPath() + "/login.html");
        }
    }
}
package filter;

import entity.Customer;
import entity.Retailer;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(value = "/retailer/safe/*")
public class CheckRetailerFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        Retailer retailer = (Retailer) session.getAttribute("retailer");
        if (retailer != null) {
            chain.doFilter(request, response);
        }else {
            res.sendRedirect(req.getContextPath() + "/login.html");
        }
    }

}
package mk.ukim.finki.lab1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.WebConnection;
import mk.ukim.finki.lab1.service.ChefService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefList", urlPatterns = "/listChefs")
public class ChefListServlet extends HttpServlet {

    private final ChefService chefService;
    private final SpringTemplateEngine springTemplateEngine;

    public ChefListServlet(ChefService chefService, SpringTemplateEngine springTemplateEngine) {
        this.chefService = chefService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("chefs", this.chefService.listChefs());
        springTemplateEngine.process("listChefs.html", context, resp.getWriter());
    }

}

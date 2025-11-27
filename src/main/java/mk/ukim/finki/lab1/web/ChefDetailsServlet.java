package mk.ukim.finki.lab1.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.lab1.model.Chef;
import mk.ukim.finki.lab1.model.Dish;
import mk.ukim.finki.lab1.service.ChefService;
import mk.ukim.finki.lab1.service.DishService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "ChefDetails", urlPatterns = "/chefDetails")
public class ChefDetailsServlet extends HttpServlet {
    private final ChefService chefService;
    private final DishService dishService;
    private final SpringTemplateEngine springTemplateEngine;

    public ChefDetailsServlet(ChefService chefService, DishService dishService, SpringTemplateEngine springTemplateEngine) {
        this.chefService = chefService;
        this.dishService = dishService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);


        WebContext context = new WebContext(webExchange);

        String dishId = req.getParameter("dishId");
        String param = req.getParameter("chefId");

        Long chefId = Long.parseLong(param);

        Dish dish = this.dishService.findByDishId(dishId);
        Chef chef = this.chefService.findById(chefId);
        chef.getDishes().add(dish);
        context.setVariable("chef", chef);
        context.setVariable("dishes", chef.getDishes());
        springTemplateEngine.process("chefDetails.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dishId = req.getParameter("dishId");
        String chefId = req.getParameter("chefId");
        String chefName = req.getParameter("chefName");
        resp.sendRedirect("/chefDetails?dishId=" + dishId + "&chefId=" + chefId);
    }
}

package org.example;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping(path = "/")
    public String index() {
        return "main";
    }

    //    @GetMapping("/logout")
    //    public String logout(HttpServletRequest request) throws Exception {
    //        request.logout();
    //        return "redirect:/";
    //    }

    @GetMapping(path = "/customers")
    @PreAuthorize("hasAnyAuthority('DEMO_ROLE')")
    public String customers(Principal principal, Model model) {
        Iterable<Customer> customers = customerDAO.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("username", principal.getName());
        return "customers";
    }

    @GetMapping(path = "/customers-private")
    public List<Customer> privateCustomers() {
        List<Customer> customers = customerDAO.findAll();
        return customers;
    }

}

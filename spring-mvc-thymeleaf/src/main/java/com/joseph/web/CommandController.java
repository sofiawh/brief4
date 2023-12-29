package com.joseph.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseph.entity.Command;
import com.joseph.entity.Customer;
import com.joseph.service.CommandService;
// import com.joseph.exception.ResourceNotFoundException;
import com.joseph.service.CustomerService;

@Controller
@RequestMapping("/command")
public class CommandController {

    private static final Logger LOG = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    private CommandService commandService;
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "welcome"; //"list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    
    @GetMapping("/search")
    public String searchCustomers(@RequestParam(required = false) String search, Model model) {
            if (search != null) { 
            	System.out.println("*************GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG*****");
                model.addAttribute("search", search);
                model.addAttribute("customers", customerService.searchCustomers(search));
                return "welcome";//"customer-list";
            }
            return "redirect:/customer/list";
        }
        

    /*@GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) throws NullPointerException {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }*//*
    @GetMapping("/passerCommande")
    public String passerCommande(@RequestParam("id") int customerId,/* HttpSession session, Model model) throws NullPointerException {
       /* Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            customer = customerService.getCustomer(customerId);
            session.setAttribute("customer", customer);
        }
    
        model.addAttribute("customer", customer);
    	 Customer customer = customerService.getCustomer(customerId);

    

    	    Command commande = new Command();
    	    model.addAttribute("commande", commande);

    	    model.addAttribute("customer", customer);
    	    return "commande-form";
    	}
    	
       		*/
 

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) throws NullPointerException {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
    @GetMapping("/error")
    public String error() {
    	return "error";
    }
}
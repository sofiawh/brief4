package com.joseph.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joseph.entity.Article;
import com.joseph.entity.Command;
import com.joseph.entity.CommandArticle;
import com.joseph.entity.Customer;
import com.joseph.service.ArticleService;
import com.joseph.service.CommandService;
// import com.joseph.exception.ResourceNotFoundException;
import com.joseph.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CommandService commandService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {
        List<Customer> theCustomers = customerService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "welcome"; //"list-customers";
    }
    @GetMapping("/listCommands")
    public String listCommands(Model theModel) {
        List<Command> theCommands = commandService.getCommands();
        theModel.addAttribute("commands", theCommands);
        return "welcome"; //"list-commands";
    }
    
    @GetMapping("/listArticles")
    public String listArticles(Model theModel) {
        List<Article> theArticles = articleService.getArticles();
        System.out.println("je suis ds listarticles "+theArticles.size());
        theModel.addAttribute("articles", theArticles);
        return "list-articles";//"welcome"; //"list-articles";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        LOG.debug("inside show customer-form handler method");
        Customer theCustomer = new Customer();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }
    @GetMapping("/showFormArticle")
    public String showFormForAddA(Model theModel) {
        LOG.debug("inside show article-form handler method");
        Article theArticle = new Article();
        theModel.addAttribute("article", theArticle);
        return "article-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
        customerService.saveCustomer(theCustomer);
        return "redirect:/customer/list";
    }
    @PostMapping("/saveArticle")
    public String saveArticle(@ModelAttribute("article") Article theArticle) {
    	System.out.println("je suis ds savearticle");
        articleService.saveArticle(theArticle);
        return "redirect:/customer/listArticles";
    }
    
    
    @GetMapping("/search")
    public String searchCustomers(@RequestParam(required = false) String search, Model model) {
            if (search != null) { 
                model.addAttribute("search", search);
                model.addAttribute("customers", customerService.searchCustomers(search));
                return "welcome";//"customer-list";
            }
            return "redirect:/customer/list";
        }
    @GetMapping("/searchArticle")
    public String searchArticles(@RequestParam(required = false) String search, Model model) {
            if (search != null) { 
            	model.addAttribute("search", search);
                model.addAttribute("articles", articleService.searchArticles(search));
                return "list-articles";//"welcome";//"customer-list";
            }
            return "redirect:/customer/listArticles";
        }

    /*@GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) throws NullPointerException {
        Customer theCustomer = customerService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }*/
    @GetMapping("/passerCommande/{id}")
    public String passerCommande(@PathVariable("id") int customerId,HttpSession session, Model model) {
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer == null) {
            customer = customerService.getCustomer(customerId);
            session.setAttribute("customer", customer);
        }
    
        model.addAttribute("customer", customer);

    	Command commande = new Command(); // Assurez-vous d'avoir une classe Commande définie
          model.addAttribute("commande", commande);
    	//Customer customer = customerService.getCustomer(customerId);
    	// model.addAttribute("customer", customer);
        return "commande-form";
    }
    
    @PostMapping("/saveCommand")
    public String saveCommand(@ModelAttribute("commande") Command theCommand) {
      //  commandService.saveCommand(theCommand);
//    	commandService.saveCommandWithParameters(theCommand);
//       System.out.println("saveCommand*******"+theCommand.toString());
//        return "redirect:/customer/list";// "commandArticle-form";
    	/*Date dateP=theCommand.getDateCmd();
    	Date date=new Date();
		if (dateP != null && !dateP.isEmpty()) {
		    try {
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		         date = (Date) dateFormat.parse(dateP);
		        } catch (ParseException e) {
		        e.printStackTrace(); */
		    Command cmd= new Command();
		    cmd.setId(1);
		    cmd.setDateCmd(new Date());
		    cmd.setCustomer(theCommand.getCustomer());
		    cmd.setState(theCommand.getState());
    	commandService.saveCommand(theCommand);
    			
        return "redirect:/commandForm";
    	
    	
    	
    }
    
    
    
    @PostMapping("/saveCommandArticle")
    public String saveCommandArticle(@ModelAttribute("commandArticle") CommandArticle theCommandArticle, Model model) {
        // Logique pour enregistrer l'article de commande
        // Assurez-vous que le service et la logique d'enregistrement sont corrects

        model.addAttribute("commandArticle", theCommandArticle);
        return "redirect:/commande-form";
    }
    
    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) throws NullPointerException {
        customerService.deleteCustomer(theId);
        return "redirect:/customer/list";
    }
}
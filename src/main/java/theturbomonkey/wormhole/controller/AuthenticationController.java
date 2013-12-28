package theturbomonkey.wormhole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthenticationController 
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String rootContext(ModelMap model) 
    {
        return "/app/pages/index.html";
    }
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model) 
	{
        return "/resources/pages/login.html";
    }
 
	
    @RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
    public String loginerror(ModelMap model) 
    {
        model.addAttribute("error", "true");
        return "/resources/pages/access-denied.html";
    }
 
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) 
    {
        return "/resources/pages/login.html";
    }
    
    
    @RequestMapping(value = "/console", method = RequestMethod.GET)
    public String console(ModelMap model) 
    {
        return "/app/pages/index.html";
    }
} // End AuthenticationController Class


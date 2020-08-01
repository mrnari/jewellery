package com.jewellery.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
/** 
 *  
 * @author narendra kusam
 *
 */

@Controller
public class AdminController {
  
	
	@GetMapping("/admin")
    public String index() {
        return "home";
    }
	
	
	
}
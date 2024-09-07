package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.Account;
import com.service.AccountService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String openIndexPage(Model model,Account account) {   // DI
		
		List<Account> accounts = accountService.findAllAccounts();
		model.addAttribute("listofaccounts", accounts);
		model.addAttribute("account", account);
		model.addAttribute("buttonValue", "Create Account");
		model.addAttribute("readonly", false);
		return "index";
	}
	
	@RequestMapping(value = "/createaccount",method = RequestMethod.POST)
	public String storeEmployee(Model model,Account account,HttpServletRequest req) {   // DI
		String result = "";
		String butonValue = req.getParameter("submitButton");
		if(butonValue.equals("Create Account")) {
			result = accountService.createAccount(account);
			System.out.println(result);
			model.addAttribute("msg", result);
		}
		return "index";
	}
	
	@RequestMapping(value = "/depositamount",method = RequestMethod.GET)
	public String depositAmount(Model model,HttpServletRequest req) {
		int accNum = Integer.parseInt(req.getParameter("accNumber"));
		Account account = accountService.findAccountByAccNum(accNum);
//		model.addAttribute("buttonValue", "Deposit Amount");
//		System.out.println(account);
		model.addAttribute("account", account);
//		model.addAttribute("buttonValue", "Deposit Amount");
//		model.addAttribute("readonly", true);
//		String butonValue = req.getParameter("submitButton");
		String result = "";
//		if(butonValue.equals("Deposit Amount")) {
			result = accountService.depositAmount(account);
			System.out.println(result);	
			model.addAttribute("msg", result);
		//}
		return "index";
	}
	
	@RequestMapping(value = "/checkbalance",method = RequestMethod.GET)
	public String checkBalance(Model model,HttpServletRequest req) {
		int accNum = Integer.parseInt(req.getParameter("accNumber"));
		String result = accountService.checkBalance(accNum);
		
		model.addAttribute("msg", result);
		return "index";
	}
}

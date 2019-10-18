package com.ajacker.controller;

import com.ajacker.domain.Account;
import com.ajacker.service.impl.AccountServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ajacker
 * @date 2019/10/18 21:33
 * Account控制器
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<Account> all = accountService.findAll();
        all.forEach(System.out::println);
        model.addAttribute("accounts", all);
        return "list";
    }


    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}

package com.ajacker.service;

import com.ajacker.domain.Account;

import java.util.List;

/**
 * @author ajacker
 * @date 2019/10/18 21:34
 */
public interface IAccountService {
    /**
     * 查询所有账户
     *
     * @return
     */
    List<Account> findAll();

    /**
     * 保存账户
     *
     * @param account 要保存的账户
     */
    void saveAccount(Account account);
}

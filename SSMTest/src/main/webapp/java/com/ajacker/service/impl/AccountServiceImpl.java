package com.ajacker.service.impl;

import com.ajacker.dao.IAccountDao;
import com.ajacker.domain.Account;
import com.ajacker.service.IAccountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ajacker
 * @date 2019/10/18 21:43
 * 业务层Account实现类
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    private final IAccountDao accountDao;

    public AccountServiceImpl(@Qualifier("accountDao") IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户");
        return accountDao.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户");
        accountDao.saveAccount(account);
    }
}

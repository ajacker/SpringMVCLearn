package com.ajacker.dao;

import com.ajacker.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ajacker
 * @date 2019/10/18 21:34
 * 账户dao接口
 */
@Repository("accountDao")
public interface IAccountDao {
    /**
     * 查询所有账户
     *
     * @return 查询结果
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 保存账户
     *
     * @param account 要保存的账户
     */
    @Insert("insert into account(name,money) values(#{name},#{money})")
    void saveAccount(Account account);

}

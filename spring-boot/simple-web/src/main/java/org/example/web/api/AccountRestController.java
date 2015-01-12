package org.example.web.api;

import java.util.List;

import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/account")
public class AccountRestController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Account> readAll() {
        return accountService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Account read(@PathVariable Integer id) {
        return accountService.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Account create(@Validated @RequestBody Account account) {
        return accountService.save(account);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Account update(@PathVariable Integer id, @Validated @RequestBody Account account) {
        account.setId(id);
        return accountService.save(account);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        accountService.delete(id);
    }
}

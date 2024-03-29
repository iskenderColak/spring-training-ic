package com.icolak.service.impl;

import com.icolak.dto.AccountDTO;
import com.icolak.repository.AccountRepository;
import com.icolak.service.AccountService;
import com.icolak.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final MapperUtil mapperUtil;

    public AccountServiceImpl(AccountRepository accountRepository, MapperUtil mapperUtil) {
        this.accountRepository = accountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<AccountDTO> getAccounts() {
        return accountRepository.findAll().stream().map(account -> mapperUtil.convert(account, new AccountDTO())).collect(Collectors.toList());
    }

    @Override
    public AccountDTO getById(Long id) throws Exception {
        return mapperUtil.convert(accountRepository.findById(id).orElseThrow(() -> new Exception("Account not found")), new AccountDTO());
    }

}

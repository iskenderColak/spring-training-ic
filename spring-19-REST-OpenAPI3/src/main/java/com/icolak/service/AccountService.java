package com.icolak.service;

import com.icolak.dto.AccountDTO;

import java.util.List;

public interface AccountService {

    List<AccountDTO> getAccounts();

    AccountDTO getById(Long id) throws Exception;

}

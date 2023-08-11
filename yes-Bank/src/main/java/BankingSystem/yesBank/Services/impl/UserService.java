package BankingSystem.yesBank.Services.impl;

import BankingSystem.yesBank.Dto.BankResponse;
import BankingSystem.yesBank.Dto.CreditDebitRequest;
import BankingSystem.yesBank.Dto.EnquiryRequest;
import BankingSystem.yesBank.Dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

     BankResponse createAccount(UserRequest userRequest);

     BankResponse balanceEnquiry(EnquiryRequest request);

     String nameEnquiry(EnquiryRequest request);

    BankResponse creditAmount(CreditDebitRequest request);

    BankResponse debitAmount(CreditDebitRequest request);


}

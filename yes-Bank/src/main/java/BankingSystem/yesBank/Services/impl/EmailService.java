package BankingSystem.yesBank.Services.impl;

import BankingSystem.yesBank.Dto.EmailDetails;
import org.springframework.stereotype.Service;


public interface EmailService {

    void sendEmailAlert(EmailDetails emailDetails);
}

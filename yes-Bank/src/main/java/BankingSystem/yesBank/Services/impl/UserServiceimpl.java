package BankingSystem.yesBank.Services.impl;

import BankingSystem.yesBank.Dto.*;
import BankingSystem.yesBank.Dto.EmailDetails;
import BankingSystem.yesBank.Entity.*;
import BankingSystem.yesBank.Entity.User;
import BankingSystem.yesBank.Repositary.UserRepository;
import BankingSystem.yesBank.Utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserServiceimpl implements UserService{
    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private EmailService emailService;


    @Override
    public BankResponse createAccount(UserRequest userRequest) {

        if(userRepository.existsByEmail(userRequest.getEmail())){
           return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User newUser=User.builder().firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .otherName(userRequest.getOtherName())
                .gender(userRequest.getGender())
                .address(userRequest.getAddress())
                .stateOfOrigin(userRequest.getStateOfOrigin())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .email(userRequest.getEmail())
                .phoneNumber(userRequest.getPhoneNumber())
                .alternativeNumber(userRequest.getAlternativeNumber())
                .status("ACTIVE")
                .build();

        User savedUser=userRepository.save(newUser);

        EmailDetails emailDetails= EmailDetails.builder()
                .recipient(savedUser.getEmail())
                .subject("Account Confirmation")
                .messageBody("Congratulations! Your Account as been sucessfully created\n"+
                        "Account Details: \n"+
                        "Account Name:"+savedUser.getFirstName()+" "+savedUser.getLastName()+" "+savedUser.getOtherName()+" \n"+
                        "Account Number:"+savedUser.getAccountNumber())
                .build();
        emailService.sendEmailAlert(emailDetails);

        return BankResponse
                .builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedUser.getAccountBalance())
                        .accountNumber(savedUser.getAccountNumber())
                        .accountName(savedUser.getFirstName()+" "+ savedUser.getLastName()+" "+savedUser.getOtherName()).build())
                .build();
    }


    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request) {
        boolean isAccountExists=userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User founduser=userRepository.findByAccountNumber(request.getAccountNumber());
        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_NUMBER_FOUND_CODE)
                .responseMessage(AccountUtils.ACCOUNT_NUMBER_FOUND_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(founduser.getAccountBalance())
                        .accountNumber(founduser.getAccountNumber())
                        .accountName(founduser.getFirstName()+" "+founduser.getLastName()+" "+founduser.getOtherName())
                        .build())
                .build();

    }

    @Override
    public String nameEnquiry(EnquiryRequest request) {
        boolean isAccountExists=userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists){
            return AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_MESSAGE;
        }
        User founduser=userRepository.findByAccountNumber(request.getAccountNumber());
        return founduser.getFirstName()+" "+founduser.getLastName()+" "+founduser.getOtherName();
    }

    @Override
    public BankResponse creditAmount(CreditDebitRequest request) {
        boolean isAccountExists=userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User userToCredit=userRepository.findByAccountNumber(request.getAccountNumber());
        userToCredit.setAccountBalance(userToCredit.getAccountBalance().add(request.getAmount()));
        userRepository.save(userToCredit);

       return  BankResponse.builder()
                .responseCode(AccountUtils.AMOUNT_CREDITED_IN_ACCOUNT_NUMBER_PROVIDED_CODE)
                .responseMessage(AccountUtils.AMOUNT_CREDITED_IN_ACCOUNT_NUMBER_PROVIDED_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(userToCredit.getAccountBalance())
                        .accountNumber(userToCredit.getAccountNumber())
                        .accountName(userToCredit.getFirstName()+" "+userToCredit.getLastName()+" "+userToCredit.getOtherName())
                        .build())
                .build();

    }

    @Override
    public BankResponse debitAmount(CreditDebitRequest request) {
        boolean isAccountExists=userRepository.existsByAccountNumber(request.getAccountNumber());
        if(!isAccountExists){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NUMBER_NOT_FOUND_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        User userToDebit=userRepository.findByAccountNumber(request.getAccountNumber());
        BigDecimal availableBalance=userToDebit.getAccountBalance();
        if(availableBalance.compareTo(request.getAmount()) < 0){
            System.out.println("/////////////////Requested amount not availabe in account////////////////////");
        }else{
            userToDebit.setAccountBalance(userToDebit.getAccountBalance().subtract(request.getAmount()));
            userRepository.save(userToDebit);
        }


        return  BankResponse.builder()
                .responseCode(AccountUtils.AMOUNT_DEBITED_IN_ACCOUNT_NUMBER_PROVIDED_CODE)
                .responseMessage(AccountUtils.AMOUNT_DEBITED_IN_ACCOUNT_NUMBER_PROVIDED_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(userToDebit.getAccountBalance())
                        .accountNumber(userToDebit.getAccountNumber())
                        .accountName(userToDebit.getFirstName()+" "+userToDebit.getLastName()+" "+userToDebit.getOtherName())
                        .build())
                .build();
    }


}

package BankingSystem.yesBank.Controllers;

import BankingSystem.yesBank.Dto.BankResponse;
import BankingSystem.yesBank.Dto.CreditDebitRequest;
import BankingSystem.yesBank.Dto.EnquiryRequest;
import BankingSystem.yesBank.Dto.UserRequest;
import BankingSystem.yesBank.Services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

//    private UserRepository userRepository;

    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest){
        return userService.createAccount(userRequest);
    }

    @GetMapping("/balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request){
        return userService.balanceEnquiry(request);
    }

    @GetMapping("/nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request){
        return userService.nameEnquiry(request);
    }

   @PatchMapping("/creditAmount")
   public BankResponse creditAmount(@RequestBody CreditDebitRequest request){
        return userService.creditAmount(request);
   }

    @PatchMapping("/debitAmount")
    public BankResponse debitAmount(@RequestBody CreditDebitRequest request){
        return userService.debitAmount(request);
    }
}

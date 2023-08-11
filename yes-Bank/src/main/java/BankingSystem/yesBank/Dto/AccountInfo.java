package BankingSystem.yesBank.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountInfo {

    private String accountName;
    private BigDecimal accountBalance;
    private String accountNumber;
}

package BankingSystem.yesBank.Utils;

import java.time.Year;

public class AccountUtils {

    public static final String ACCOUNT_EXISTS_CODE="001";
    public static final String ACCOUNT_EXISTS_MESSAGE="THIS USER ACCOUNT ALREADY EXISTS";

    public static final String ACCOUNT_CREATION_SUCCESS="002";
    public static final String ACCOUNT_CREATION_MESSAGE="ACCOUNT SUCCESSFULLY CREATED";

    public static final String ACCOUNT_NUMBER_NOT_FOUND_CODE="003";
    public static final String ACCOUNT_NUMBER_NOT_FOUND_MESSAGE="ACCOUNT NUMBER PROVIDED NOT FOUND";

    public static final String ACCOUNT_NUMBER_FOUND_CODE="004";
    public static final String ACCOUNT_NUMBER_FOUND_MESSAGE="ACCOUNT NUMBER PROVIDED  FOUND";

    public static final String AMOUNT_CREDITED_IN_ACCOUNT_NUMBER_PROVIDED_CODE ="005";
    public static final String AMOUNT_CREDITED_IN_ACCOUNT_NUMBER_PROVIDED_MESSAGE="AMOUNT CREDITED IN THE ACCOUNT";

    public static final String AMOUNT_DEBITED_IN_ACCOUNT_NUMBER_PROVIDED_CODE ="006";
    public static final String AMOUNT_DEBITED_IN_ACCOUNT_NUMBER_PROVIDED_MESSAGE="AMOUNT DEBITED IN THE ACCOUNT";
    public static String generateAccountNumber() {
        Year currentYear=Year.now();

        int min=100000;
        int max=999999;

        int randNumber=(int) Math.floor(Math.random() * (max-min+1)+min);

        String year=String.valueOf(currentYear);
        String randomNumber= String.valueOf(randNumber);

        StringBuilder accountNumber=new StringBuilder();

        return accountNumber.append(year).append(randomNumber).toString();

    }
}

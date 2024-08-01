package com.application.balance;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.pojo.AccountDetails;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BalanceDetails {
	private static Logger logger = LogManager.getLogger(BalanceDetails.class);
	public static BigDecimal getBalanceDetails(AccountDetails accountDetails) {
		logger.info("Please Enter your Deposit Amount:");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		BigDecimal depositValue = scanner.nextBigDecimal();
		logger.info("");
		accountDetails.setDepositAmt(depositValue);
		BigDecimal balance = accountDetails.getBalance().add(accountDetails.getDepositAmt());
		logger.info("Your Deposit Amount is: {}" , accountDetails.getDepositAmt());
		accountDetails.setBalance(balance);
		logger.info("Your Balance after Deposit is: {}" , accountDetails.getBalance());
		logger.info("Your Final Balance : {}" , accountDetails.getBalance());
		logger.info("");
		return balance;
	}
}

package com.application.accounts;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.menu.Menu;
import com.application.pojo.AccountDetails;

import lombok.experimental.UtilityClass;

@UtilityClass
public class CurrentBankAccount {
	private static Logger logger = LogManager.getLogger(CurrentBankAccount.class);

	public static void withdrawl(AccountDetails accDetails) {
		if (accDetails.getBalance() == BigDecimal.ZERO) {
			logger.info("Your Account Balance is : {}", accDetails.getBalance());
			logger.info(", Please Deposit some amount and Try Later :-(");
			Menu.currentBankAccount(accDetails);
		} else {
			logger.info("Please Enter your Withdrawl Amount: ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			BigDecimal withdrawlValue = scanner.nextBigDecimal();
			logger.info("");
			accDetails.setWithdrawAmt(withdrawlValue);
			accDetails.setBalance(accDetails.getBalance().subtract(accDetails.getWithdrawAmt()));
			accDetails.setWithdrawAmt(accDetails.getTotalWithdrawAmt().add(accDetails.getWithdrawAmt()));
			logger.info("Withdrawl Amount for this transaction is: {}", accDetails.getWithdrawAmt());
			logger.info("Total Withdrawl Amount is : {}", accDetails.getTotalWithdrawAmt());
			logger.info("Balance after Withdrawl is: {}", accDetails.getBalance());
			accDetails.setBalance(accDetails.getBalance());
			logger.info("Final Balance : {}", accDetails.getBalance());
			logger.info("");
		}
	}
}

package com.application.accounts;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.menu.Menu;
import com.application.pojo.AccountDetails;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SavingsBankAccount {
	private static BigDecimal minBal = BigDecimal.valueOf(500.00);
	private static BigDecimal transLimit = BigDecimal.valueOf(50000.00);
	private static Logger logger = LogManager.getLogger(SavingsBankAccount.class);

	public static void withdrawl(AccountDetails accDetails) {
		if (accDetails.getBalance().compareTo(BigDecimal.ZERO) == 0) {
			logger.info("Total Withdawl value : {}", accDetails.getTotalWithdrawAmt());
			logger.info("Your Account Balance is : {}", accDetails.getBalance());
			logger.info(", Please Deposit some amount and Try Later :-(\n");
			Menu.savingsBankAccount(accDetails);
		} else {
			logger.info("Please Enter your Withdrawl Amount: ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			BigDecimal withdrawlValue = scanner.nextBigDecimal();
			logger.info("");
			if (accDetails.getTotalWithdrawAmt().compareTo(transLimit) > 0) {
				accDetails.setTotalWithdrawAmt(accDetails.getTotalWithdrawAmt().add(withdrawlValue));
				logger.info("Your Transaction Limit is exceeded today!");
				Menu.savingsBankAccount(accDetails);
			} else if (withdrawlValue.compareTo(transLimit) > 0) {
				logger.info("Your Daily Transaction Limit is {}", transLimit);
				logger.info(", Please try amount lower than your Daily Transaction Limit");
				Menu.savingsBankAccount(accDetails);
			} else if (accDetails.getBalance().subtract(withdrawlValue).compareTo(minBal) <= 0) {
				logger.info("Your Account balance is : {}", accDetails.getBalance());
				logger.info(", you are draining off of Minimum Balance, please try someother amount!");
				Menu.savingsBankAccount(accDetails);
			} else {
				accDetails.setWithdrawAmt(withdrawlValue);
				accDetails.setBalance(accDetails.getBalance().subtract(accDetails.getWithdrawAmt()));
				accDetails.setTotalWithdrawAmt(accDetails.getTotalWithdrawAmt().add(withdrawlValue));
				logger.info("Withdrawl Amount for this transaction is: {}", accDetails.getWithdrawAmt());
				logger.info("Total Withdrawl Amount is : {}", accDetails.getTotalWithdrawAmt());
				logger.info("Balance after Withdrawl is: {}", accDetails.getBalance());
				accDetails.setBalance(accDetails.getBalance());
				logger.info("Final Balance : {}", accDetails.getBalance());
				logger.info("");
			}
		}
	}
}

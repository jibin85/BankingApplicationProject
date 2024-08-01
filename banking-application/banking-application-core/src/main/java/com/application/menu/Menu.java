package com.application.menu;

import java.math.BigDecimal;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.application.accounts.CurrentBankAccount;
import com.application.accounts.SavingsBankAccount;
import com.application.balance.BalanceDetails;
import com.application.pojo.AccountDetails;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Menu {
	private static Logger logger = LogManager.getLogger(Menu.class);
	private static final String CHOICE_LOG = "Please Enter your choice : ";

	/**
	 * To Create a Menu system for overall banking
	 */
	public static void mainMenu() {
		processMenu(new AccountDetails());
	}

	/**
	 * This is the Process Menu at run time
	 * 
	 * @param accountDetails
	 */
	private static void processMenu(AccountDetails accountDetails) {
		logger.info("****************************************** Welcome ***************************************** \n");
		logger.info("1. Savings Bank Account \t 2. Current Bank Account \t 3. Exit \n");
		logger.info(CHOICE_LOG);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int selectAccount = scanner.nextInt();
		logger.info("");
		switch (selectAccount) {
		case 1:
			savingsBankAccount(accountDetails);
			break;
		case 2:
			currentBankAccount(accountDetails);
			break;
		case 3:
			terminate();
			break;
		default:
			logger.info("Enter a valid choice!\n");
			mainMenu();
			break;
		}
	}

	/**
	 * To create a Menu for Savings Account Holders
	 * 
	 * @param accountDetails
	 */
	public static void savingsBankAccount(AccountDetails accountDetails) {
		logger.info("************************ Welcome to your SAVINGS ACCOUNT ************************ \n");
		logger.info("1. Deposit \t 2. Withdraw \t 3. Enquire \t 4. Previous Menu \t 5. Exit \n");
		logger.info(CHOICE_LOG);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		logger.info("");
		switch (choice) {
		case 1:
			BalanceDetails.getBalanceDetails(accountDetails);
			savingsBankAccount(accountDetails);
			break;
		case 2:
			SavingsBankAccount.withdrawl(accountDetails);
			savingsBankAccount(accountDetails);
			break;
		case 3:
			bankAccountDetails(accountDetails);
			savingsBankAccount(accountDetails);
			break;
		case 4:
			processMenu(accountDetails);
			break;
		case 5:
			terminate();
			break;
		default:
			logger.info("Please Enter Valid Choice!\n");
			savingsBankAccount(accountDetails);
			break;
		}
	}

	/**
	 * To create a Menu for Current Account Holders
	 * 
	 * @param accountDetails
	 */
	public static void currentBankAccount(AccountDetails accountDetails) {
		logger.info("************************ Welcome to your CURRENT ACCOUNT ************************ \n");
		logger.info("1. Deposit \t 2. Withdraw \t 3. Enquire \t 4. Previous Menu \t 5. Exit \n");
		logger.info(CHOICE_LOG);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice = scanner.nextInt();
		logger.info("");
		switch (choice) {
		case 1:
			BalanceDetails.getBalanceDetails(accountDetails);
			currentBankAccount(accountDetails);
			break;
		case 2:
			CurrentBankAccount.withdrawl(accountDetails);
			currentBankAccount(accountDetails);
			break;
		case 3:
			bankAccountDetails(accountDetails);
			currentBankAccount(accountDetails);
			break;
		case 4:
			processMenu(accountDetails);
			break;
		case 5:
			terminate();
			break;
		default:
			logger.info("Please Enter Valid Choice!\n");
			currentBankAccount(accountDetails);
			break;
		}
	}

	/**
	 * To View the Bank Account Details
	 * 
	 * @param accountDetails
	 */
	private static void bankAccountDetails(AccountDetails accountDetails) {
		BigDecimal balanceValue = accountDetails.getBalance();
		logger.info("############# Your Bank Account Details #############");
		accountDetails.setBankAccountNo("0075053000020411");
		logger.info("Your Bank A/C no : {}", accountDetails.getBankAccountNo());
		accountDetails.setBankAccountName("Jibin Thomas");
		logger.info("Your Bank A/C Name : {}", accountDetails.getBankAccountName());
		logger.info("Your Balance is : {}", balanceValue);
		accountDetails.setDateOfOpenning("21-02-2014");
		logger.info("Date of Opening : {}", accountDetails.getDateOfOpenning());
		logger.info("#####################################################");
		logger.info("");
	}

	/**
	 * To Terminate the Application
	 */
	private static void terminate() {
		logger.info("Happy Banking Thanks!!");
		System.exit(0);
	}
}

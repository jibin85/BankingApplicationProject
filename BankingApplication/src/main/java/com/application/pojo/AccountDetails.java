package com.application.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class AccountDetails {
	private String bankAccountNo;
	private String bankAccountName;
	private BigDecimal balance = BigDecimal.ZERO;
	private String dateOfOpenning;
	private BigDecimal depositAmt;
	private BigDecimal withdrawAmt = BigDecimal.ZERO;
	private BigDecimal totalWithdrawAmt = BigDecimal.ZERO;
}

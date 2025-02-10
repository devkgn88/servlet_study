package com.gn.vo;

public class Account {
	private int accountNo;
	private String accountId;
	private String accountPw;
	
	public Account() {
		super();
	}

	public Account(int accountNo, String accountId, String accountPw) {
		super();
		this.accountNo = accountNo;
		this.accountId = accountId;
		this.accountPw = accountPw;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountPw() {
		return accountPw;
	}

	public void setAccountPw(String accountPw) {
		this.accountPw = accountPw;
	}


	@Override
	public String toString() {
		return "[번호=" + accountNo + ", 아이디=" + accountId + ", 비번=" + accountPw + "]";
	}
	
	
	
	
}

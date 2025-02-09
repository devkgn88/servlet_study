package com.gn.vo;

public class AccountVo {
	private int accountNo;
	private String accountId;
	private String accountPw;
	private String rememberId;
	
	public AccountVo() {
		super();
	}

	public AccountVo(int accountNo, String accountId, String accountPw, String rememberId) {
		super();
		this.accountNo = accountNo;
		this.accountId = accountId;
		this.accountPw = accountPw;
		this.rememberId = rememberId;
	}
	
	
}

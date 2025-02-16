package com.gn.board.vo;

public class Attach {
	private int attachNo;
	private int boardNo;
	private String oriName;
	private String newName;
	private String attachPath;
	
	public Attach() {}

	public Attach(int attachNo, int boardNo, String oriName, String newName, String attachPath) {
		this.attachNo = attachNo;
		this.boardNo = boardNo;
		this.oriName = oriName;
		this.newName = newName;
		this.attachPath = attachPath;
	}

	public int getAttachNo() {
		return attachNo;
	}

	public void setAttachNo(int attachNo) {
		this.attachNo = attachNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getOriName() {
		return oriName;
	}

	public void setOriName(String oriName) {
		this.oriName = oriName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getAttachPath() {
		return attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	@Override
	public String toString() {
		return "[번호=" + attachNo 
				+ ", 게시글 번호=" + boardNo 
				+ ", 기존 명칭=" + oriName 
				+ ", 변환 명칭=" + newName
				+ ", 파일 경로=" + attachPath + "]";
	}
}

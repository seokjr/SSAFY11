package com.ssafy.fit.model.dao;

public class NoNotFoundException extends Exception {

    private int No;
    
    public NoNotFoundException(int no) {
        super(no + "번호인 비디오가 존재하지 않습니다.");
        this.No = no;
    }
    
    public int getNo() { return this.No; }
    
}
package com.crud.tasks.domain;

import lombok.Getter;

@Getter
public class Mail {
    final String receiverEail;
    private String toCC = null;
    final String subject;
    final String message;

    public Mail(String receiverEail, String subject, String message) {
        this.receiverEail = receiverEail;
        this.subject = subject;
        this.message = message;
    }

    public Mail(String receiverEail, String toCC, String subject, String message) {
        this.receiverEail = receiverEail;
        this.toCC = toCC;
        this.subject = subject;
        this.message = message;
    }
}

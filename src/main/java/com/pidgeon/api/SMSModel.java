package com.pidgeon.api;

public class SMSModel {
  private String recipient;
  private String message;
  private String id;

  public SMSModel() {}

  public SMSModel(String id, String recipient, String message) {
    this.id = id;
    this.recipient = recipient;
    this.message = message;
  }

  public String getRecipient() {
    return recipient;
  }

  public String getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }

  public void setRecipient(String recipient) {
    this.recipient = recipient;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setId(String id) {
    this.id = id;
  }

}

package src.utils;

import src.models.Customer;

public class Message {
  public Customer customer;
  public String message;

  public Message (Customer customer) {
    this.customer = customer;
  }

  public void sendMessage(String[] messages) {
    System.out.println("Уведомление для "+customer.name+":");
    for (String message : messages) {
      System.out.println(message);
    }
  }
}

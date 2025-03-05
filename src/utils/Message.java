/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.utils;
import src.models.Customer;

public class Message implements Cloneable {
  public Customer customer;

   /**
   * Конструктор класу Message.
   * @param customer Об'єкт клієнта, що відправляє повідомлення.
   */
  public Message(Customer customer) {
    this.customer = customer;
  }

  public Message(Message original) {
      this.customer = original.customer;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
      return super.clone();
  }

    /**
   * Відправляє повідомлення клієнту.
   * @param messages Масив повідомлень для відправки.
   */
  public void sendMessage(String[] messages) {
    System.out.println("Уведомление для "+customer.name+":");
    for (String message : messages) {
      System.out.println(message);
    }
  }
}

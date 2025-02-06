/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.models;

/**
 * Клас Passager описує пасажира, його характеристики та інформацію про багаж.
 */
public class Passager {
  public static int nextId;
  public int id;
  public double bagWeight;
  public String placeClass;
  public boolean isChild;

   /**
   * Конструктор класу Passager.
   * @param bagWeight Вага багажу пасажира.
   * @param placeClass Клас місця пасажира (звичайний або VIP).
   * @param isChild Чи є пасажир дитиною.
   */
  public Passager (double bagWeight, String placeClass, boolean isChild) {
    this.id = Passager.incrementId();

    this.bagWeight = bagWeight;
    this.placeClass = placeClass;
    this.isChild = isChild;
  }

  /**
   * Збільшує ID для кожного нового пасажира.
   * @return Новий ID пасажира.
   */
  private static int incrementId () {
    Customer.nextId++;
    return Customer.nextId;
  }
}

/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.models;

import src.config.Cities;

/**
 * Клас Customer описує клієнта, його характеристику та інформацію про пасажирів.
 */
public class Customer {
  public static int nextId;
  public int id;
  public String name;
  public City startCity;
  public City finalCity;
  public Passager[] passagers;

  /**
   * Конструктор класу Customer.
   * @param name Ім'я клієнта.
   * @param startCityId ID початкового міста.
   * @param finalCityId ID кінцевого міста.
   * @param passagers Масив пасажирів, які подорожують з клієнтом.
   */
  public Customer (String name, int startCityId, int finalCityId, Passager[] passagers) {
    this.id = Customer.incrementId();
    this.name = name;
    this.startCity = Cities.getCityById(startCityId);
    this.finalCity = Cities.getCityById(finalCityId);
    this.passagers = passagers;
  }

  /**
   * Збільшує ID для кожного нового клієнта.
   * @return Новий ID клієнта.
   */
  private static int incrementId () {
    Customer.nextId++;
    return Customer.nextId;
  }
}

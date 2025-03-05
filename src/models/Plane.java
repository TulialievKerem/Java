/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import src.AssistClass;
import src.config.Cities;

/**
 * Клас Plane описує літак, його характеристики та інформацію про рейс.
 */
public class Plane extends AssistClass {
  public static int nextId;
  public int id;
  public String name;
  public int maxPlaces;
  public int maxVipPlaces;
  public int occupedPlacesAmount;
  public int occupedVipPlacesAmount;
  public Date departureTime;
  public City startCity;
  public City finalCity;

   /**
   * Конструктор класу Plane.
   * @param name Назва літака.
   * @param startCityId ID початкового міста.
   * @param finalCityId ID кінцевого міста.
   */
  public Plane (String name, int startCityId, int finalCityId) {
    this.id = Plane.incrementId();
    this.name = name;
    this.maxPlaces = 100;
    this.maxVipPlaces = 20;
    this.occupedPlacesAmount = new Random().nextInt(maxPlaces);
    this.occupedVipPlacesAmount = new Random().nextInt(maxVipPlaces);
    this.departureTime = getDepartureTime(5, 181);
    
    this.startCity = Cities.getCityById(startCityId);
    this.finalCity = Cities.getCityById(finalCityId);
  }

  /**
   * Отримує час відправлення.
   * @param minDepartureTime Мінімальний час відправлення.
   * @param maxDepartureTime Максимальний час відправлення.
   * @return Час відправлення у форматі Date.
   */
  public Date getDepartureTime(int minDepartureTime, int maxDepartureTime) {
    Calendar calendar = Calendar.getInstance();
    int randomMinutes = ThreadLocalRandom.current().nextInt(minDepartureTime, maxDepartureTime);
    calendar.add(Calendar.MINUTE, randomMinutes);
    Date departureTime = calendar.getTime();
    return departureTime;
  }

  /**
   * Перевіряє, чи літак вже відправився.
   * @return true, якщо літак відправився, інакше false.
   */
  public boolean isDepartured () {
    Date dateNow = Calendar.getInstance().getTime();
    if(departureTime.before(dateNow)) {
      return true;
    }
    return false;
  }

  /**
   * Збільшує ID для кожного нового літака.
   * @return Новий ID літака.
   */
  private static int incrementId () {
    Plane.nextId++;
    return Plane.nextId;
  }
}

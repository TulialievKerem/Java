/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.models;

/**
 * Клас City описує місто та його характеристики.
 */
public class City {
  public static int nextId;
  public int id = 1;
  public String name;
  public int coordinateX;
  public int coordinateY;

  /**
   * Конструктор класу City.
   * @param name Назва міста.
   * @param coordinateX Координата X міста.
   * @param coordinateY Координата Y міста.
   */
  public City (String name, int coordinateX, int coordinateY) {
    this.id = City.incrementId();
    this.name = name;
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
    City.incrementId();
  }

  /**
   * Збільшує ID для кожного нового міста.
   * @return Новий ID міста.
   */
  private static int incrementId () {
    City.nextId++;
    return City.nextId;
  }
}

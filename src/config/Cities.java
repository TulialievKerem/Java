/**
 * @version 1.0
 * @author Tulialiev Kerem
 */
package src.config;

import src.models.City;

/**
 * Клас Cities містить інформацію про міста та надає методи для роботи з ними.
 */
public class Cities {
  public static City[] cityList = {
    new City("Moscow", 100, 77),
    new City("Kyiv", 43, 5),
    new City("Night city", 932, 23),
    new City("Texas", 100, 1),
  };

  /**
   * Повертає місто за його ID.
   * @param cityId ID міста.
   * @return Об'єкт міста або null, якщо місто не знайдено.
   */
  public static City getCityById (int cityId) {
    City city = null;
    for (int i = 0; i < Cities.cityList.length; i++) {
      City cityEl = Cities.cityList[i];
      if(cityEl.id == cityId) {
        city = cityEl;
        break;
      }
    }
    return city;
  }
}

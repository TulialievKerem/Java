package src.config;

import src.models.City;

public class Cities {
  public static City[] cityList = {
    new City("Moscow", 100, 77),
    new City("Kyiv", 43, 5),
    new City("Night city", 932, 23),
    new City("Texas", 100, 1),
  };

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

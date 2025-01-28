package src.models;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import src.config.Cities;

public class Plane {
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

  public Date getDepartureTime(int minDepartureTime, int maxDepartureTime) {
    Calendar calendar = Calendar.getInstance();
    int randomMinutes = ThreadLocalRandom.current().nextInt(minDepartureTime, maxDepartureTime);
    calendar.add(Calendar.MINUTE, randomMinutes);
    Date departureTime = calendar.getTime();
    return departureTime;
  }

  public boolean isDepartured () {
    Date dateNow = Calendar.getInstance().getTime();
    if(departureTime.before(dateNow)) {
      return true;
    }
    return false;
  }

  private static int incrementId () {
    Plane.nextId++;
    return Plane.nextId;
  }
}

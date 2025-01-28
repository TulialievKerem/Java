package src.models;

import src.config.Cities;

public class Customer {
  public static int nextId;
  public int id;
  public String name;
  public City startCity;
  public City finalCity;
  public Passager[] passagers;

  public Customer (String name, int startCityId, int finalCityId, Passager[] passagers) {
    this.id = Customer.incrementId();
    this.name = name;
    this.startCity = Cities.getCityById(startCityId);
    this.finalCity = Cities.getCityById(finalCityId);
    this.passagers = passagers;
  }

  private static int incrementId () {
    Customer.nextId++;
    return Customer.nextId;
  }
}

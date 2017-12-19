package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the food_item database table.
 * 
 */
@Entity
@Table(name="food_item")
@NamedQuery(name="FoodItem.findAll", query="SELECT f FROM FoodItem f")
public class FoodItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="food_id")
	private int foodId;

	@Column(name="food_name")
	private String foodName;

	//bi-directional many-to-one association to City
	@OneToMany(mappedBy="foodItem")
	private List<City> cities;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="foodItem")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to FoodItemMapping
	@OneToMany(mappedBy="foodItem")
	private List<FoodItemMapping> foodItemMappings;

	//bi-directional many-to-one association to Restaurant
	@OneToMany(mappedBy="foodItem")
	private List<Restaurant> restaurants;

	public FoodItem() {
	}

	public int getFoodId() {
		return this.foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return this.foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public List<City> getCities() {
		return this.cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public City addCity(City city) {
		getCities().add(city);
		city.setFoodItem(this);

		return city;
	}

	public City removeCity(City city) {
		getCities().remove(city);
		city.setFoodItem(null);

		return city;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setFoodItem(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setFoodItem(null);

		return feedback;
	}

	public List<FoodItemMapping> getFoodItemMappings() {
		return this.foodItemMappings;
	}

	public void setFoodItemMappings(List<FoodItemMapping> foodItemMappings) {
		this.foodItemMappings = foodItemMappings;
	}

	public FoodItemMapping addFoodItemMapping(FoodItemMapping foodItemMapping) {
		getFoodItemMappings().add(foodItemMapping);
		foodItemMapping.setFoodItem(this);

		return foodItemMapping;
	}

	public FoodItemMapping removeFoodItemMapping(FoodItemMapping foodItemMapping) {
		getFoodItemMappings().remove(foodItemMapping);
		foodItemMapping.setFoodItem(null);

		return foodItemMapping;
	}

	public List<Restaurant> getRestaurants() {
		return this.restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		getRestaurants().add(restaurant);
		restaurant.setFoodItem(this);

		return restaurant;
	}

	public Restaurant removeRestaurant(Restaurant restaurant) {
		getRestaurants().remove(restaurant);
		restaurant.setFoodItem(null);

		return restaurant;
	}

}
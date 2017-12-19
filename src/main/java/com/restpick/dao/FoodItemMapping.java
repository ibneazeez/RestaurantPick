package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the food_item_mapping database table.
 * 
 */
@Entity
@Table(name="food_item_mapping")
@NamedQuery(name="FoodItemMapping.findAll", query="SELECT f FROM FoodItemMapping f")
public class FoodItemMapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FoodItemMappingPK id;

	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="food_id")
	private FoodItem foodItem;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;

	//bi-directional many-to-one association to Restaurant
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;

	public FoodItemMapping() {
	}

	public FoodItemMappingPK getId() {
		return this.id;
	}

	public void setId(FoodItemMappingPK id) {
		this.id = id;
	}

	public FoodItem getFoodItem() {
		return this.foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Restaurant getRestaurant() {
		return this.restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
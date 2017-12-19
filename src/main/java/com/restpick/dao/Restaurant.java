package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the restaurant database table.
 * 
 */
@Entity
@NamedQuery(name="Restaurant.findAll", query="SELECT r FROM Restaurant r")
public class Restaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restaurant_id")
	private int restaurantId;

	private String description;

	@Column(name="map_location")
	private String mapLocation;

	@Column(name="mobile_number")
	private String mobileNumber;

	@Column(name="restaurant_name")
	private String restaurantName;

	private String website;

	//bi-directional many-to-one association to FoodItemMapping
	@OneToMany(mappedBy="restaurant")
	private List<FoodItemMapping> foodItemMappings;

	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="food_id")
	private FoodItem foodItem;

	public Restaurant() {
	}

	public int getRestaurantId() {
		return this.restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMapLocation() {
		return this.mapLocation;
	}

	public void setMapLocation(String mapLocation) {
		this.mapLocation = mapLocation;
	}

	public String getMobileNumber() {
		return this.mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRestaurantName() {
		return this.restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<FoodItemMapping> getFoodItemMappings() {
		return this.foodItemMappings;
	}

	public void setFoodItemMappings(List<FoodItemMapping> foodItemMappings) {
		this.foodItemMappings = foodItemMappings;
	}

	public FoodItemMapping addFoodItemMapping(FoodItemMapping foodItemMapping) {
		getFoodItemMappings().add(foodItemMapping);
		foodItemMapping.setRestaurant(this);

		return foodItemMapping;
	}

	public FoodItemMapping removeFoodItemMapping(FoodItemMapping foodItemMapping) {
		getFoodItemMappings().remove(foodItemMapping);
		foodItemMapping.setRestaurant(null);

		return foodItemMapping;
	}

	public FoodItem getFoodItem() {
		return this.foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

}
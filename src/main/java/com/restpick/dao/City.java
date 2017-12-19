package com.restpick.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the city database table.
 * 
 */
@Entity
@NamedQuery(name="City.findAll", query="SELECT c FROM City c")
public class City implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="city_id")
	private int cityId;

	@Column(name="city_name")
	private String cityName;

	private String pincode;

	//bi-directional many-to-one association to FoodItem
	@ManyToOne
	@JoinColumn(name="food_id")
	private FoodItem foodItem;

	//bi-directional many-to-one association to FoodItemMapping
	@OneToMany(mappedBy="city")
	private List<FoodItemMapping> foodItemMappings;

	public City() {
	}

	public int getCityId() {
		return this.cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return this.cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public FoodItem getFoodItem() {
		return this.foodItem;
	}

	public void setFoodItem(FoodItem foodItem) {
		this.foodItem = foodItem;
	}

	public List<FoodItemMapping> getFoodItemMappings() {
		return this.foodItemMappings;
	}

	public void setFoodItemMappings(List<FoodItemMapping> foodItemMappings) {
		this.foodItemMappings = foodItemMappings;
	}

	public FoodItemMapping addFoodItemMapping(FoodItemMapping foodItemMapping) {
		getFoodItemMappings().add(foodItemMapping);
		foodItemMapping.setCity(this);

		return foodItemMapping;
	}

	public FoodItemMapping removeFoodItemMapping(FoodItemMapping foodItemMapping) {
		getFoodItemMappings().remove(foodItemMapping);
		foodItemMapping.setCity(null);

		return foodItemMapping;
	}

}
package Meal_project.Meal_project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Meal")
public class Meal{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long Id;
	

	@Column(name="Date", columnDefinition="VARCHAR(11)")	//DD.MM.YYYY.
	private String date;

	@Column(name="Time", columnDefinition="VARCHAR(5)")		//HH:MM
	private String time;

	@Column(name="Description", columnDefinition="VARCHAR(200)")	
	private String description;

	@Column(name="Calories", columnDefinition="int")	
	private int calories;
		
	public Meal(String date, String time, String description, int calories) {
		this.date = date;
		this.time = time;
		this.description = description;
		this.calories = calories;
	}
	
	public Meal(){}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	
	

}

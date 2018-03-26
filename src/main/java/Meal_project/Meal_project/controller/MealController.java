package Meal_project.Meal_project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Meal_project.Meal_project.model.Meal;
import Meal_project.Meal_project.model.ShowMeal;
import Meal_project.Meal_project.repo.MealRepository;

@RestController
@RequestMapping(value = "/api/index")
public class MealController {

	@Autowired
	private MealRepository mealrepository;
	
	
	@RequestMapping(value = "/getSearchResults", method = RequestMethod.GET)
	public ArrayList<Meal> getSearchResults(){
		return mealrepository.getSearchResults();
	}
	
	@RequestMapping(value = "/getMeals", method = RequestMethod.GET)
	public ArrayList<ShowMeal> getMeals() throws ParseException{
		System.out.println("Get all the meals - method");

		
		String year_i = "";
		String year_j = "";
		//sorting years
		for(int i = 0; i < mealrepository.getShowMeals().size();i++) {
			for(int j = 0; j < mealrepository.getShowMeals().size();j++){
				year_i = mealrepository.getShowMeals().get(i).getDate().substring(0, 4);
				year_j = mealrepository.getShowMeals().get(j).getDate().substring(0, 4);
				//System.out.println(year_i + " " + year_j);
				if(Integer.parseInt(year_j) < Integer.parseInt(year_i)) {
					ShowMeal temp;
					temp = mealrepository.getShowMeals().get(i);
					mealrepository.getShowMeals().set(i, mealrepository.getShowMeals().get(j));
					mealrepository.getShowMeals().set(j, temp);					
				}
			}
		}
		
		String month_i = "";
		String month_j = "";		
		for(int i = 0; i < mealrepository.getShowMeals().size();i++) {
			for(int j = 0; j < mealrepository.getShowMeals().size();j++){
				month_i = mealrepository.getShowMeals().get(i).getDate().substring(6, 7);
				month_j = mealrepository.getShowMeals().get(j).getDate().substring(6, 7);
				//System.out.println(month_i + " " + month_j);
				if(Integer.parseInt(month_i) < Integer.parseInt(month_j)) {
					ShowMeal temp;
					temp = mealrepository.getShowMeals().get(i);
					mealrepository.getShowMeals().set(i, mealrepository.getShowMeals().get(j));
					mealrepository.getShowMeals().set(j, temp);					
				}
			}
		}
		
		String day_i = "";
		String day_j = "";		
		for(int i = 0; i < mealrepository.getShowMeals().size();i++) {
			for(int j = 0; j < mealrepository.getShowMeals().size();j++){
				day_i = mealrepository.getShowMeals().get(i).getDate().substring(6, 7);
				day_j = mealrepository.getShowMeals().get(j).getDate().substring(6, 7);
				//System.out.println(day_i + " " + day_j);
				if(Integer.parseInt(day_i) < Integer.parseInt(day_j)) {
					ShowMeal temp;
					temp = mealrepository.getShowMeals().get(i);
					mealrepository.getShowMeals().set(i, mealrepository.getShowMeals().get(j));
					mealrepository.getShowMeals().set(j, temp);					
				}
			}
		}
		
		return mealrepository.getShowMeals();
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public Meal addMeal(@RequestBody Meal meal){
		mealrepository.getMeals().add(meal);
		
		if(!mealrepository.getDates().contains(meal.getDate())) {
			mealrepository.getDates().add(meal.getDate());
		}
		
		for(String s : mealrepository.getDates()) {
			ShowMeal sm = new ShowMeal();
			sm.setDate(s);
			for(Meal m : mealrepository.getMeals()) {
				if(m.getDate().equals(sm.getDate())) {
					sm.getDesctiptions().add(m.getDescription());
					sm.getTimes().add(m.getTime());
					sm.setSummedCalories(sm.getSummedCalories()+m.getCalories());					
				}
			}		
			mealrepository.getShowMeals().add(sm);
		}
		
		ArrayList<ShowMeal> template = new ArrayList<ShowMeal>();
		template.clear();
		for(int i = mealrepository.getShowMeals().size()-1; 
				i >= mealrepository.getShowMeals().size()-mealrepository.getDates().size(); i--) {
			System.out.println("DODAT U TMPLATE");
			System.out.println("BROJ DATUMA " + mealrepository.getDates().size());
			template.add(mealrepository.getShowMeals().get(i));
		}
		
		
		/*
		System.out.println("Broj elemenata je " + mealrepository.getShowMeals().size());
		System.out.println("-------------------");
		for(ShowMeal sm : mealrepository.getShowMeals()) {
			System.out.println(sm.getDate());
			for(String s : sm.getDesctiptions()){
				System.out.println(s);
			}
			for(String s : sm.getTimes()){
				System.out.println(s);
			}
			System.out.println(sm.getSummedCalories());
		}
		System.out.println("-------------------");
		
*/
		/*
		
		System.out.println("-----------------------------");
		for(ShowMeal sm : template) {
			System.out.println(sm.getDate());
			for(String s : sm.getDesctiptions()){
				System.out.println(s);
			}
			for(String s : sm.getTimes()){
				System.out.println(s);
			}
			System.out.println(sm.getSummedCalories());
		}
		System.out.println("-----------------------------");
		
		*/
		
		
		/*
		 * if(mealrepository.getMeals().isEmpty()){
			mealrepository.getMeals().add(meal);
		}else {
			for(int i = 0; i < mealrepository.getMeals().size();i++) {
				if(mealrepository.getMeals().get(i).getDate().equals(meal.getDate())) {
					mealrepository.getMeals().get(i).
						setCalories(mealrepository.getMeals().get(i).
							getCalories()+meal.getCalories());
				}else continue;
			}
			
		}
		 * 
		 * 
		 * */
		/*
		System.out.println("Add meal");
		for(String s : mealrepository.getDates()) {
			System.out.println(s);
		}*/
		
		mealrepository.getShowMeals().clear();
		mealrepository.setShowMeals(template);
		return meal;
	}
	
	@RequestMapping(value="searchMeals",method = RequestMethod.POST, consumes="application/json")
	public ArrayList<Meal> search(@RequestBody Meal meal){
		//System.out.println("Searching...");
		ArrayList<Meal> retVal = new ArrayList<Meal>();
		System.out.println(meal.getDescription());
		for(Meal m : mealrepository.getMeals()) {
			if(m.getDescription().trim()!="" && m.getDescription().contains(meal.getDescription())) {
				retVal.add(m);
				System.out.println("->");
			}
		}
		mealrepository.setSearchResults(retVal);	
		return retVal;
		
	}
}

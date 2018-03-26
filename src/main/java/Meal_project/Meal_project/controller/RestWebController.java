package Meal_project.Meal_project.controller;


import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Meal_project.Meal_project.message.Response;
import Meal_project.Meal_project.model.Meal;

@RestController
@RequestMapping("/api/customer")
public class RestWebController {
 
	ArrayList<Meal> cust = new ArrayList<Meal>();
 
	@GetMapping(value = "/all")
	public Response getResource() {
		Response response = new Response("Done", cust);
		return response;
	}
 
	@PostMapping(value = "/save")
	public Response postCustomer(@RequestBody Meal meal) {
		cust.add(meal);
		
		// Create Response Object
		Response response = new Response("Done", meal);
		return response;
	}
}

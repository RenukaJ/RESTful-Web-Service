package com.vehiclerest.jersey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.vehiclerest.jersey.Vehicle;

@Path("/vehicles")
public class VehicleService {

	// should simulate database here
	private static Map<Integer, Vehicle> vehiclesMap = new HashMap<Integer, Vehicle>();

	// insert test data into simulated database
	static {
		for (int i = 0; i < 10; i++) {
			Vehicle vehicle = new Vehicle();
			int id = i + 1;
			vehicle.setId(id);
			vehicle.setYear(new Random().nextInt(100) + 1950);
			vehicle.setMake("Audi");
			vehicle.setModel("Z4");

			vehiclesMap.put(id, vehicle);

		}
	}

	// returns a single vehicle object in JSON format
	@GET
	@Path("/vehicles/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehicle getVehicleById(@PathParam("id") int id) {
		return vehiclesMap.get(id);
	}

	
//	@GET
//	@Path("/getVehicleByIdJSON/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Vehicle getVehicleByIdJSON(@PathParam("id") int id) {
//		return vehiclesMap.get(id);
//	}

	
//	@GET
//	@Path("/getAllVehiclesXML/vehicles")
//	@Produces(MediaType.APPLICATION_XML)
//	public List<Vehicle> getAllVehiclesXML() {
//		return new ArrayList<Vehicle>(vehiclesMap.values());
//	}
	
	// returns a list of all vehicle objects in XML format
	@GET
	@Path("/vehicles")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vehicle> getAllVehiclesJSON() {
		List<Vehicle> vehicles =  new ArrayList<Vehicle>(vehiclesMap.values());
		
		return vehicles;

	}
	
	
	//
	// // deletes all vehicle objects from vehiclesMap
	// @DELETE
	// @Path("/deleteAllVehiclesXML")
	// @Produces(MediaType.APPLICATION_XML)
	// public List<Vehicle> deleteAllVehiclesXML() {
	// vehiclesMap.clear();
	// Vehicle newV = new Vehicle();
	// vehiclesMap.put(1, newV);
	// return new ArrayList<Vehicle>(vehiclesMap.values());
	//
	// }
	//
	 // deletes vehicle object per id
	 @DELETE
	 @Path("/vehicles/{id}")
//	 @Produces(MediaType.APPLICATION_JSON)
	 public void deleteVehicle(@PathParam("id") int id) {
	 vehiclesMap.remove(id);
//	 return new ArrayList<Vehicle>(vehiclesMap.values());
	 }
	
	//
	 @POST
	 @Produces({ MediaType.APPLICATION_JSON })
	 @Path("/vehicles")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public void createVehicle(Vehicle vehicle) {
	 int id = vehicle.getId();
	 if((vehicle.getYear()>= 1950 && vehicle.getYear() < 2050) || vehicle.getModel() == null || vehicle.getMake() == null || vehicle.getModel().isEmpty() || vehicle.getMake().isEmpty())
		 System.out.println("invalid model or make");
	 id = vehiclesMap.size();
	 while(vehiclesMap.containsKey(id)){
		 id = id+1;
	 }
	 vehicle.setId(id);
	 System.out.println(id +" post updated");

	 vehiclesMap.put(id, vehicle);
	 System.out.println(id);
//	 return vehicle;
//	 List<Vehicle> vehicles =  new ArrayList<Vehicle>(vehiclesMap.values());
	 
	 }
	
	// update vehicle
	 @PUT
//	 @Produces({ MediaType.APPLICATION_JSON })
	 @Path("/vehicles")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Vehicle putVehicle(Vehicle vehicle) {
	 int id = vehicle.getId();
	 if(vehiclesMap.containsKey(id)){
		 vehiclesMap.put(id, vehicle);
	 }
	 System.out.println(id +"updated");
	 return vehicle;
	 }
	 

}

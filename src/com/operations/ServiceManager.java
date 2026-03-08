package com.operations;
import java.util.*;


public class ServiceManager {
	private static Map<String, List<Service>> reservationServices = new HashMap<>();
	
	public static void addService(String reservationId, Service service) {
		reservationServices.putIfAbsent(reservationId, new ArrayList<>());
		reservationServices.get(reservationId).add(service);
		System.out.println(service.getName()+" added to reservaion "+reservationId);
		
	}
	
	public static void showServices(String reservationId) {
		List<Service> services = reservationServices.get(reservationId);
		if(services==null) {
			System.out.println("No services added.");
			return;
		}
		
		System.out.println("Services for reservation "+reservationId);
		for(Service s:services) {
			System.out.println(s.getName()+" : "+s.getPrice());
		}
	}
	
	public static double calculateServiceCost(String reservationId) {
		List<Service> services = reservationServices.get(reservationId);
		if(services==null) return 0;
		double total =0;
		
		for(Service s : services) {
			total +=s.getPrice();
		}
		return total;
	}
}

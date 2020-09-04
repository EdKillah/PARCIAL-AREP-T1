package edu.escuelaing.arep.services;

import java.util.ArrayList;
import java.util.List;

import edu.escuelaing.arep.ordenamiento.BubbleSort;

public class OwnList {

	public static List<Double> list;

	public List<Double> createList(String[] numeros) {

		ArrayList<Double> numbers = new ArrayList<Double>();
		for (String s : numeros) {
			numbers.add(Double.valueOf(s));
		}

		list =  orderList(numbers);

		System.out.println("Numbers: " + numbers);
		return orderList(numbers);


	}

	public List<Double> orderList(ArrayList<Double> numbers) {
		BubbleSort bubble = new BubbleSort();

		List<Double> orderedList = bubble.sort(numbers.toArray());
		System.out.println("En sparkweb: " + orderedList);

		return orderedList;

	}

	public String getOperations(List<Double> orderedList) {
		ModifyList alterate = new ModifyList();

		Double suma = alterate.getSuma(orderedList.toArray());
		Double promedio = alterate.getPromedio(orderedList.toArray());

		System.out.println("Suma en ownList: " + suma);
		System.out.println("Promedio en ownList: " + promedio);

		String json = '{' + "\"numeros\"" + ":" + orderedList.toString() + ", " + "\"suma\"" + ":" + suma + ", "
				+ "\"promedio\"" + ":" + promedio + '}';
		
		System.out.println("Json: " + json);
		return json;
		
	}

}

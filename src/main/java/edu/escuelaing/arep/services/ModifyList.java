package edu.escuelaing.arep.services;

public class ModifyList {

	public Double getSuma(Object arr[]) {
		Double suma = 0.0;
		for (int i = 0; i < arr.length; i++) {
			suma += (Double) arr[i];
		}
		
		return suma;
	}

	public Double getPromedio(Object arr[]) {
		
		return getSuma(arr) / arr.length;

	}

}

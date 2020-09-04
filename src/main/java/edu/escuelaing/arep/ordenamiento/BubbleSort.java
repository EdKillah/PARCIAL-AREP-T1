package edu.escuelaing.arep.ordenamiento;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	public List<Double> sort(Object list[]) {

		int n = list.length;
		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < n - i - 1; j++) {
				// Aca podemos crear una clase que almacene objetos propios con un atributo
				// value y ese lo usamos
				if ((Double) list[j] > (Double) list[j + 1]) {

					double temp = (Double) list[j];
					list[j] = list[j + 1];
					list[j + 1] = temp;
				}

			}
		}

		return parseList(list);
	}

	private List<Double> parseList(Object list[]) {
		ArrayList<Double> lista = new ArrayList<Double>();
		for (Object s : list) {
			lista.add(Double.valueOf(s.toString()));
		}

		System.out.println("Lista ordenada: " + lista);
		return lista;
	}

}

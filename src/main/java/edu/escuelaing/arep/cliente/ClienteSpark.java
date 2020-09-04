package edu.escuelaing.arep.cliente;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import edu.escuelaing.arep.sparkweb.SparkWebApp;

/**
 * Cliente encargado de probar el proyecto desplegado en Heroku
 * 
 * @author Eduard Jimenez
 *
 */
public class ClienteSpark {

	public static void main(String[] args) {

		try {
			// En la siguiente variable se colocan los numeros que se quieren enviar a la
			// aplicación
			// Deben ser enviados con el formato que tiene la variable "lista".

			String lista = "9-1.4-1.2-33-21-100.4";

			URL site = new URL("https://vast-springs-40762.herokuapp.com/results?lista=" + lista);
		

			// Las lineas de abajo son para leer la información del sitio web

			Scanner sc = new Scanner(site.openStream());
			StringBuffer sb = new StringBuffer();
			while (sc.hasNext()) {
				sb.append(sc.next());
			}

			String result = sb.toString();
			System.out.println("INFORMACIÓN RETORNADA POR EL SITIO WEB EN HEROKU: ");
			System.out.println(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

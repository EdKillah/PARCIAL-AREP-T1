package edu.escuelaing.arep.sparkweb;

import static spark.Spark.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


import edu.escuelaing.arep.services.OwnList;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import spark.Request;
import spark.Response;

public class SparkWebApp {

	/**
	 * Main method set staticFils location, recives get petitions from client side
	 * and set a port to work.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		staticFiles.location("/public"); // La cosa più importante per caricare i static files
		port(getPort());
		get("/hello", (req, res) -> "Hello Heroku, you are working");
		get("/index", SparkWebApp::inputDataPage, new ThymeleafTemplateEngine());
		get("/", SparkWebApp::inputDataPage, new ThymeleafTemplateEngine());
		get("/results", SparkWebApp::resultsPage);
	}

	/**
	 * Gets heroku's port if its given one, otherwise returns 4567 by defult.
	 * 
	 * @return
	 */
	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 4567; // returns default port if heroku-port isn't set

	}

	/**
	 * 
	 * @param req request made from client side
	 * @param res response from server
	 * @return ModelAndView html page with elements to be renderized using thymleaf
	 */
	private static ModelAndView inputDataPage(Request req, Response res) {
		Map<String, Object> params = new HashMap<>();
		return new ModelAndView(params, "index");
	}

	/**
	 * resultsPage returns results page with mean and standar deviation of number
	 * list passed by req
	 * 
	 * @param req request made from client side
	 * @param res response from server
	 * @return ModelAndView html page with elements to be renderized
	 */
	public static String resultsPage(Request req, Response res) {

		String lista = req.queryParams("lista");
		System.out.println("Resultados: " + lista);

		String[] numeros = lista.split("-");

		OwnList own = new OwnList();
		List<Double> ordenados = own.createList(numeros);

		return own.getOperations(ordenados);

	}
}
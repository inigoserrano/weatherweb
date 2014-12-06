package com.inigoserrano.weatherweb.rest;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.util.JSON;

@Path("/obtener/")
@Produces("application/json")
public class Obtener {

	@GET
	@Path("/todo")
	public String getTodo() {
		StringBuffer respuesta = new StringBuffer();
		try {
			DB db = obtenerConexion();
			DBCollection coleccion = db.getCollection("weatherweb");

			Iterator<DBObject> iterator = coleccion.find().iterator();
			while (iterator.hasNext()) {
				DBObject dbObject = iterator.next();
				respuesta.append(JSON.serialize(dbObject));
			}

			return respuesta.toString();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}

	private DB obtenerConexion() throws UnknownHostException {
		String usuario = System.getProperty("OPENSHIFT_MONGODB_DB_USERNAME");
		String contrasena = System.getProperty("OPENSHIFT_MONGODB_DB_PASSWORD");
		String host = System.getProperty("OPENSHIFT_MONGODB_DB_HOST", "localhost");
		String puerto = System.getProperty("OPENSHIFT_MONGODB_DB_PORT", "27017");

		MongoCredential credential = MongoCredential.createMongoCRCredential(usuario, "weatherweb", contrasena.toCharArray());
		MongoClient mongo = new MongoClient(new ServerAddress(host, Integer.parseInt(puerto)), Arrays.asList(credential));
		DB db = mongo.getDB("weatherweb");
		return db;
	}

}

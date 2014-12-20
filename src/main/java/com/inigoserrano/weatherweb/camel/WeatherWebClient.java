package com.inigoserrano.weatherweb.camel;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class WeatherWebClient extends MongoClient {

	private static final String usuario = System.getProperty("OPENSHIFT_MONGODB_DB_USERNAME");
	private static final String contrasena = System.getProperty("OPENSHIFT_MONGODB_DB_PASSWORD");
	private static final String host = System.getProperty("OPENSHIFT_MONGODB_DB_HOST", "localhost");
	private static final String puerto = System.getProperty("OPENSHIFT_MONGODB_DB_PORT", "27017");

	private static final MongoCredential credential = MongoCredential.createMongoCRCredential(usuario, "weatherweb", contrasena.toCharArray());

	public WeatherWebClient() throws UnknownHostException {
		super(new ServerAddress(host, Integer.parseInt(puerto)), Arrays.asList(credential));
	}

}

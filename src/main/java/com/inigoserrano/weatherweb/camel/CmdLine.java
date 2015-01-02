package com.inigoserrano.weatherweb.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

public class CmdLine {

	public static void main(String[] args) {
		try {
			SimpleRegistry registry = new SimpleRegistry();
			registry.put("conexion", new WeatherWebClient());
			CamelContext context = new DefaultCamelContext(registry);
			context.addRoutes(new CargaDatosRoute());
			context.start();
			for (int i = 60; i > 0; i--) {
				Thread.sleep(1000);
				System.out.println(i + " seg.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

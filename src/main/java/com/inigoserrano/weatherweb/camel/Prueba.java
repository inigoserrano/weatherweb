package com.inigoserrano.weatherweb.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class Prueba {

	public static void main(String[] args) {
		try {
			CamelContext context = new DefaultCamelContext();
			context.addRoutes(new CargaDatosRoute());
			context.start();
			for (int i = 0; i < 1000; i++) {
				Thread.sleep(100);
				System.out.println(i);

			}
			// Thread.sleep(40000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.inigoserrano.weatherweb.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.SplitDefinition;

public class CargaDatosRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		RouteDefinition cargado = from("file:///Users/inigo/workspace/pruebaFuse/datos/entrada");
		SplitDefinition dividido = cargado.split(body(String.class).tokenize("\n")).parallelProcessing();
		dividido.filter().javaScript("request.body.match(/^[0-9]/) != null").transform().javaScript("resource:classpath:substitucion.js")
		.to("file:///Users/inigo/workspace/pruebaFuse/datos/salida?fileExist=Append");

	}

}

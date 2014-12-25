package com.inigoserrano.weatherweb.camel;

import java.util.HashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.ExpressionNode;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;

public class CargaDatosRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		RouteDefinition cargado = from("file:///Users/inigo/workspace/pruebaFuse/datos/entrada?noop=true");
		ExpressionNode dividido = cargado.split(body(String.class).tokenize("\n")).parallelProcessing().process(new ParseoCSV());
		ProcessorDefinition<ExpressionNode> json = dividido.marshal().json(JsonLibrary.Jackson);
		json.to("file:///Users/inigo/workspace/pruebaFuse/datos/salida?fileExist=Append");

	}

	private final class ParseoCSV implements Processor {
		@Override
		public void process(Exchange exchange) throws Exception {
			Map<String, Object> nuevoBody = new HashMap<String, Object>();
			String[] tokens = exchange.getIn().getBody(String.class).split("\t");
			nuevoBody.put("No", Integer.parseInt(arreglarValor(tokens[0])));
			nuevoBody.put("Time", arreglarValor(tokens[1]));
			nuevoBody.put("Interval", arreglarValor(tokens[2]));
			nuevoBody.put("Indoor_Humidity", arreglarValor(tokens[3]));
			nuevoBody.put("Indoor_Temperature", arreglarValor(tokens[4]));
			nuevoBody.put("Outdoor_Humidity", arreglarValor(tokens[5]));
			nuevoBody.put("Outdoor_Temperature", arreglarValor(tokens[6]));
			nuevoBody.put("Absolute_Pressure", arreglarValor(tokens[7]));
			nuevoBody.put("Wind", arreglarValor(tokens[8]));
			nuevoBody.put("Gust", arreglarValor(tokens[9]));
			nuevoBody.put("Direction", arreglarValor(tokens[10]));
			nuevoBody.put("Relative_Pressure", arreglarValor(tokens[11]));
			nuevoBody.put("Dewpoint", arreglarValor(tokens[12]));
			nuevoBody.put("Windchill", arreglarValor(tokens[13]));
			nuevoBody.put("Hour_Rainfall", arreglarValor(tokens[14]));
			nuevoBody.put("Day_hour_Rainfall", arreglarValor(tokens[15]));
			nuevoBody.put("Week_Rainfall", arreglarValor(tokens[16]));
			nuevoBody.put("Month_Rainfall", arreglarValor(tokens[17]));
			nuevoBody.put("Total_Rainfall", arreglarValor(tokens[18]));
			nuevoBody.put("Wind_Level", arreglarValor(tokens[19]));
			nuevoBody.put("Gust_Level", arreglarValor(tokens[20]));
			exchange.getIn().setBody(nuevoBody, nuevoBody.getClass());

		}

		private String arreglarValor(String valor) {
			if (valor.equals("___")) {
				return "0";
			} else {
				return valor;
			}
		}
	}

}

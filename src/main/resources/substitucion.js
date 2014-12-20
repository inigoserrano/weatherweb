function arreglarValor(valor){
	if (valor == '___'){
		return 0;
	}else {
		return valor;
	}
}


var tokens = request.body.match(/[a-zA-Z0-9\. :-]+/g);
var respuesta;
respuesta = '{ "No" : ' + arreglarValor(tokens[0]) + " , ";
respuesta += ' "Time" : "' + arreglarValor(tokens[1]) + '" , ';
respuesta += ' "Interval" : ' + arreglarValor(tokens[2]) + ' , ';
respuesta += ' "Indoor_Humidity" : ' + arreglarValor(tokens[3]) + " , ";
respuesta += ' "Indoor_Temperature" : ' + arreglarValor(tokens[4]) + " , ";
respuesta += ' "Outdoor_Humidity" : ' + arreglarValor(tokens[5]) + " , ";
respuesta += ' "Outdoor_Temperature" : ' + arreglarValor(tokens[6]) + " , ";
respuesta += ' "Absolute_Pressure" : ' + arreglarValor(tokens[7]) + " , ";
respuesta += ' "Wind" : ' + arreglarValor(tokens[8]) + " , ";
respuesta += ' "Gust" : ' + arreglarValor(tokens[9]) + " , ";
respuesta += ' "Direction" : "' + arreglarValor(tokens[10]) + '" , ';
respuesta += ' "Relative_Pressure" : ' + arreglarValor(tokens[11]) + " , ";
respuesta += ' "Dewpoint" : ' + arreglarValor(tokens[12]) + " , ";
respuesta += ' "Windchill" : ' + arreglarValor(tokens[13]) + " , ";
respuesta += ' "Hour_Rainfall" : ' + arreglarValor(tokens[14]) + " , ";
respuesta += ' "Day_hour_Rainfall" : ' + arreglarValor(tokens[15]) + " , ";
respuesta += ' "Week_Rainfall" : ' + arreglarValor(tokens[16]) + " , ";
respuesta += ' "Month_Rainfall" : ' + arreglarValor(tokens[17]) + " , ";
respuesta += ' "Total_Rainfall" : ' + arreglarValor(tokens[18]) + " , ";
respuesta += ' "Wind_Level" : ' + arreglarValor(tokens[19]) + " , ";
respuesta += ' "Gust_Level" : ' + arreglarValor(tokens[20]);
respuesta += '}\n';
request = respuesta;
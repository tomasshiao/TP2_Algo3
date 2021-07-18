package algoteg.datosJuego;

import algoteg.*;
import java.util.*;

public class InitializeTarjetas {
    private final List<Tarjeta> todasLasTarjetas;
    private final Map<String, String> mapaTarjetasYSimbolos;
    private final List<Pais> listaPaises;

    public InitializeTarjetas(List<Pais> paises){
        this.listaPaises = paises;
        this.mapaTarjetasYSimbolos = setMapaTarjetasYSimbolos();
        this.todasLasTarjetas = this.setTarjetas();
    }

    public Map<String, String> setMapaTarjetasYSimbolos() {
        Map<String, String> mapaTarjetasYSimbolos = new HashMap<>();
        mapaTarjetasYSimbolos.put("Francia", "Globo");
        mapaTarjetasYSimbolos.put("Gran Bretaña", "Barco");
        mapaTarjetasYSimbolos.put("Tartaria","Cañon");
        mapaTarjetasYSimbolos.put("Mongolia","Barco");
        mapaTarjetasYSimbolos.put("Zaire","Barco");
        mapaTarjetasYSimbolos.put("Polonia","Cañon");
        mapaTarjetasYSimbolos.put("Oregon","Cañon");
        mapaTarjetasYSimbolos.put("Etiopia","Globo");
        mapaTarjetasYSimbolos.put("Chile","Globo");
        mapaTarjetasYSimbolos.put("Australia","Cañon");
        mapaTarjetasYSimbolos.put("Kamtchatka","Globo");
        mapaTarjetasYSimbolos.put("Egipto","Globo");
        mapaTarjetasYSimbolos.put("Turquia","Barco");
        mapaTarjetasYSimbolos.put("Nueva York","Barco");
        mapaTarjetasYSimbolos.put("Terranova","Cañon");
        mapaTarjetasYSimbolos.put("Iran","Globo");
        mapaTarjetasYSimbolos.put("Madagascar","Barco");
        mapaTarjetasYSimbolos.put("Argentina","Comodin");
        mapaTarjetasYSimbolos.put("Israel","Barco");
        mapaTarjetasYSimbolos.put("Rusia","Globo");
        mapaTarjetasYSimbolos.put("Borneo","Barco");
        mapaTarjetasYSimbolos.put("California","Cañon");
        mapaTarjetasYSimbolos.put("Taymir","Comodin");
        mapaTarjetasYSimbolos.put("Aral","Cañon");
        mapaTarjetasYSimbolos.put("Siberia","Barco");
        mapaTarjetasYSimbolos.put("Canada","Cañon");
        mapaTarjetasYSimbolos.put("Sahara","Cañon");
        mapaTarjetasYSimbolos.put("Yukon","Globo");
        mapaTarjetasYSimbolos.put("Uruguay","Globo");
        mapaTarjetasYSimbolos.put("Groenlandia","Globo");
        mapaTarjetasYSimbolos.put("Japon","Cañon");
        mapaTarjetasYSimbolos.put("Sumatra","Globo");
        mapaTarjetasYSimbolos.put("Alaska","Barco");
        mapaTarjetasYSimbolos.put("Brasil","Barco");
        mapaTarjetasYSimbolos.put("Gobi","Globo");
        mapaTarjetasYSimbolos.put("Italia","Globo");
        mapaTarjetasYSimbolos.put("España","Globo");
        mapaTarjetasYSimbolos.put("Colombia","Globo");
        mapaTarjetasYSimbolos.put("Suecia","Barco");
        mapaTarjetasYSimbolos.put("Sudafrica","Cañon");
        mapaTarjetasYSimbolos.put("Arabia","Cañon");
        mapaTarjetasYSimbolos.put("India","Globo");
        mapaTarjetasYSimbolos.put("Java","Cañon");
        mapaTarjetasYSimbolos.put("Mexico","Cañon");
        mapaTarjetasYSimbolos.put("Peru","Barco");
        mapaTarjetasYSimbolos.put("Alemania","Barco");
        mapaTarjetasYSimbolos.put("China","Barco");
        mapaTarjetasYSimbolos.put("Labrador","Cañon");
        mapaTarjetasYSimbolos.put("Islandia","Barco");
        mapaTarjetasYSimbolos.put("Malasia","Cañon");
        return mapaTarjetasYSimbolos;
    }

    public List<Tarjeta> setTarjetas(){
        List<Tarjeta> tarjetas = new ArrayList<>();
        for (Pais p : listaPaises){
            String stringDibujo = this.mapaTarjetasYSimbolos.get(p.getNombre());
            Tarjeta t = new Tarjeta(p, stringDibujo);
            tarjetas.add(t);
        }
        return tarjetas;
    }

    public List<Tarjeta> getTodasLasTarjetas(){
        return this.todasLasTarjetas;
    }

}
package algoteg;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import javafx.scene.control.TextArea;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Partida {

    private int cantidadTotalJugadores;
    private int cantidadJugadoresActuales;
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private List<Tarjeta> tarjetas;

    public Partida(int cantidadTotalJugadores) {
        cantidadJugadoresActuales = 0;
        if (cantidadTotalJugadores <= 6)
            this.cantidadTotalJugadores = cantidadTotalJugadores;
        else this.cantidadTotalJugadores = 6;
        this.tarjetas = this.iniciarTarjetas();
    }

    public void agregarJugador(Jugador unJugador) {
        int idJugador = unJugador.getId();
        if (jugadores.size() < this.cantidadTotalJugadores) {
            jugadores.add(unJugador);
            this.cantidadJugadoresActuales++;
        }
    }

    public int getCantidadJugadoresActuales() {
        return cantidadJugadoresActuales;
    }

    //Crea las tarjetas y las pone en una lista
    private List<Tarjeta> iniciarTarjetas(){
        JSONParser jsonParser = new JSONParser();
        List<Tarjeta> tarjetas = new ArrayList<>();



        try (FileReader fr = new FileReader("D:\\DOCUMENTOS\\FACULTAD\\ALGO3\\TP2\\TP2_Algo3_TEG\\src\\main\\java\\algoteg\\datosJuego\\Teg - Cartas.json", StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(fr))         {
            Object obj = jsonParser.parse(reader);

            JSONArray listaTarjetas = (JSONArray) obj;



            listaTarjetas.forEach( tarjeta -> tarjetas.add(parseListaTarjetas( (JSONObject) tarjeta )) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ParseException e) {
            e.printStackTrace();
        }



        return(tarjetas);

    }


    private static Tarjeta parseListaTarjetas(JSONObject tarjeta)
    {

        //Get employee first name
        String pais = (String) tarjeta.get("Pais");


        //Get employee last name
        String simbolo = (String) tarjeta.get("Simbolo");


        return(new Tarjeta(pais,simbolo));
    }
}

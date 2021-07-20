package algoteg.datosJuego;

import algoteg.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class InitializeObjetivos {
    private ArrayList<Jugador> jugadores;
    private Tablero tablero;
    private List<Objetivo> objetivos = new ArrayList<>();
    public static final String SEPARADOR = ";";

    public InitializeObjetivos(ArrayList<Jugador> jugadores, Tablero tablero){
        this.jugadores = jugadores;
        this.tablero = tablero;
        inicializarObjetivos();
    }

    public List<Objetivo> getObjetivos(){
        return this.objetivos;
    }

    private void inicializarObjetivos(){
        ArrayList<String[]> lineaObjetivo;
        lineaObjetivo = readCsvArchive();
        for(String[] obj: lineaObjetivo)
            if(obj[0].equals("Destruccion"))
                agregarObjetivoDeDestruccion(obj);
    }

    private void agregarObjetivoDeDestruccion(String[] obj) {
        String colorADestruir = obj[1];
        Objetivo objetivo = new ObjetivoPorDestruccion(colorADestruir, this.jugadores);
        objetivo.setMensajeObjetivo(obj[2]);
        this.objetivos.add(objetivo);
    }

    private ArrayList<String[]> readCsvArchive() {
        ArrayList<String[]> listaObjetivos = new ArrayList<>();
        BufferedReader bufferLectura = null;
        try {
            bufferLectura = new BufferedReader(new FileReader("src/main/java/algoteg/datosJuego/listaObjetivos.csv"));

            String linea = bufferLectura.readLine();

            while (linea != null) {
                String[] campos = linea.split(SEPARADOR);
                listaObjetivos.add(campos);
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaObjetivos;
    }
}
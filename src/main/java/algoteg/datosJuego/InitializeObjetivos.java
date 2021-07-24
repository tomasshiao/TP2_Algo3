package algoteg.datosJuego;

import algoteg.modelo.*;

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
            else if(obj[0].equals("Conquista"))
                agregarObjetivoDeConquista(obj);
    }

    private void agregarObjetivoDeConquista(String[] obj){
        boolean objetivoConLimitrofes = false;
        int cantidadLimitrofesAConquistar = 0;
        Map<Continente, Integer> paisesAConquistar = new HashMap<>();

        for(int i=1; i<(obj.length-2);i+=2){
            if(!obj[i].equals("limitrofes")) {
                Continente continente = tablero.getContinente(obj[i]);
                int cantidadAConquistar = Integer.parseInt(String.valueOf(obj[i + 1]));
                paisesAConquistar.put(continente,cantidadAConquistar);
            }
            else {
                //listaTodosLosPaises = tablero.getPaises();
                cantidadLimitrofesAConquistar = Integer.parseInt(String.valueOf(obj[i + 1]));
                objetivoConLimitrofes = true;
            }

        }
        Objetivo objetivo;
        if(objetivoConLimitrofes)
            objetivo = new ObjetivoDeConquista(paisesAConquistar, cantidadLimitrofesAConquistar);
        else objetivo = new ObjetivoDeConquista(paisesAConquistar);
        int finalArray = obj.length-1;    //accede a la ultima posicion del array donde esta la descripcion
        objetivo.setMensajeObjetivo(obj[finalArray]);
        this.objetivos.add(objetivo);

    }

    private void agregarObjetivoDeDestruccion(String[] obj) {
        String colorADestruir = obj[1];
        Objetivo objetivo = new ObjetivoDeDestruccion(colorADestruir, this.jugadores);
        int finalArray = obj.length-1;
        objetivo.setMensajeObjetivo(obj[finalArray]);
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
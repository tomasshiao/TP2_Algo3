package algoteg.modelo;

import algoteg.Exceptions.MoverEjercitoException;

import java.util.*;

public class Jugador {
    private final String color;
    private final int id;
    private List<Tarjeta> tarjetas = new ArrayList<>();
    private List<Pais> paisesConquistados = new ArrayList<>();
    private Objetivo objetivo;
    private Map<Continente, Integer> ejercitoDisponiblePorContinente = new HashMap<>();
    int ejercitoDisponibleGlobal;
    private int canjesRealizados;
    private boolean estaVivo;


    public Jugador(int id, String color) {
        this.id = id;
        this.color = color;
        this.canjesRealizados = 0;
        this.ejercitoDisponibleGlobal = 0;
        this.estaVivo = true;

    }

    public void setContinentes(List<Continente> continentes){
        for(Continente continente: continentes) {
            ejercitoDisponiblePorContinente.put(continente, 0);
        }

    }

    public void setEjercitoDisponibles(List<Continente> continentes){
        for(Continente continente: continentes) {
            ejercitoDisponiblePorContinente.put(continente, continente.getBonusTropas());
        }
        ejercitoDisponibleGlobal = getCantidadPaisesConquistados()/2;
    }

    public String getColor(){
        return color;
    }

    public int getId(){
        return id;
    }

    public void addTarjeta(Tarjeta tarjeta){
        tarjetas.add(tarjeta);
    }

    private void removeTarjeta(Tarjeta tarjeta){
        int index = 0;
        int i = 0;
        for(Tarjeta a: tarjetas) {
            if (a == tarjeta)
                index = i;
            i++;
        }
        tarjetas.remove(index);
    }

    public int getTarjetasEnSuPoder(){
        return tarjetas.size();
    }

    public void addEjercito(int ejercitoParaIncorporar){
        this.ejercitoDisponibleGlobal += ejercitoParaIncorporar;
    }

    public void addEjercitoEnPais(Pais pais, int ejercito) {
        if(!this.tienePais(pais)) {return;}
        int ejercitoPorColocar = ejercito;
        for (Map.Entry<Continente, Integer> entry : ejercitoDisponiblePorContinente.entrySet()) {
            Continente continente = entry.getKey();
            Integer ejercitoDisponible = entry.getValue();
            if (continente.tienePais(pais)) {
                if (ejercitoDisponible <= ejercitoPorColocar) {
                    pais.agregarEjercito(ejercitoDisponible);
                    ejercitoPorColocar -= ejercitoDisponible;
                    ejercitoDisponiblePorContinente.put(continente, 0);
                } else {
                    pais.agregarEjercito(ejercitoPorColocar);
                    ejercitoDisponiblePorContinente.put(continente, ejercitoDisponible - ejercitoPorColocar);
                    ejercitoPorColocar = 0;
                }
            }
        }
        if(ejercitoDisponibleGlobal <= ejercitoPorColocar) {
            pais.agregarEjercito(ejercitoDisponibleGlobal);
            ejercitoDisponibleGlobal = 0;
        }
        else {
            pais.agregarEjercito(ejercitoPorColocar);
            ejercitoDisponibleGlobal -= ejercitoPorColocar;
        }


    }


    public int getEjercitoParaIncorporar(){
        int ejercitoDisponible = ejercitoDisponibleGlobal;
        for (Map.Entry<Continente, Integer> entry : ejercitoDisponiblePorContinente.entrySet()) {
            ejercitoDisponible += entry.getValue().intValue();
        }
        return ejercitoDisponible;
    }

    public boolean canjearTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2, Tarjeta tarjeta3){
        if (tarjeta1.compararTarjetas(tarjeta2, tarjeta3)) {
            this.canjesRealizados++;
            int ejercitoAIncorporar = this.calcluarEjercitoSegunCanjes();
            this.addEjercito(ejercitoAIncorporar);
            this.removeTarjeta(tarjeta1);
            this.removeTarjeta(tarjeta2);
            this.removeTarjeta(tarjeta3);
            return true;
        }
        return false;
    }

    public boolean compararJugadores(Jugador jugador2) { return (this.getColor().equals(jugador2.getColor())); }

    public void activarTarjeta(Tarjeta tarjeta){
        Pais paisDeTarjeta = tarjeta.getPaisDeTarjeta();
        int ejercitoAIncorporar = 0;

        if(this.paisesConquistados.contains(paisDeTarjeta) && this.tarjetas.contains(tarjeta))
            ejercitoAIncorporar = tarjeta.activarTarjeta();
        this.addEjercito(ejercitoAIncorporar);
    }

    public void addPaisConquistado(Pais pais){
        paisesConquistados.add(pais);
    }

    public List<Pais> getPaisesConquistados(){
        return this.paisesConquistados;
    }


    private int calcluarEjercitoSegunCanjes(){
        int ejercitoAIncorporar;

        if(this.canjesRealizados == 0) return 0;

        switch(this.canjesRealizados){
            case 1: {
                ejercitoAIncorporar = 4;
                break;
            }
            case 2: {
                ejercitoAIncorporar = 7;
                break;
            }
            case 3: {
                ejercitoAIncorporar = 10;
                break;
            }
            default:
                ejercitoAIncorporar = (this.canjesRealizados-1)*5;
        }
        return ejercitoAIncorporar;
    }

    public int getCantidadPaisesConquistados() {
        return (paisesConquistados.size());
    }

    public void setPaises(List<Pais> listaPaises) {
        this.paisesConquistados.addAll(listaPaises);
    }

    public void agregarPaisInicial(Pais pais){
        this.paisesConquistados.add(pais);
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

/*    public void setEjercitoParaIncorporar(int ejercitoParaIncorporar) {
        this.ejercitoParaIncorporar += ejercitoParaIncorporar;
    } METODO DUPLICADO */

    public boolean estaVivo(){
        return this.estaVivo = this.getCantidadPaisesConquistados() > 0;
    }



    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Objetivo getObjetivo(){
        return this.objetivo;
    }

    public boolean esGanador(){return this.objetivo.cumplido();} // se fija si cumple objetivos

    public boolean tienePais(Pais pais){
        return (paisesConquistados.contains(pais));


    }

}
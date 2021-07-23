package algoteg;

import algoteg.Exceptions.AtaqueInvalidoException;
import algoteg.Exceptions.MoverEjercitoException;

import java.util.*;

public class Jugador {
    private String color;
    private int id;
    private List<Tarjeta> tarjetas = new ArrayList<>();
    private List<Pais> paisesConquistados = new ArrayList<>();
    private Objetivo objetivo;
    private int ejercitoParaIncorporar;
    private int canjesRealizados;
    private boolean estaVivo;

    public Jugador(int id, String color) {
        this.id = id;
        this.color = color;
        this.ejercitoParaIncorporar = 0;
        this.canjesRealizados = 0;
        this.estaVivo = true;
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
        this.ejercitoParaIncorporar += ejercitoParaIncorporar;
    }

    public void addEjercitoEnPais(Pais pais, int ejercito){
        if(paisesConquistados.contains(pais) && this.ejercitoParaIncorporar >= ejercito){
            pais.agregarEjercito(ejercito);
            this.ejercitoParaIncorporar -= ejercito;
        }
    }

    public int getEjercitoParaIncorporar(){
        return ejercitoParaIncorporar;
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

    public void activarTarjeta (Tarjeta tarjeta){
        Pais paisDeTarjeta = tarjeta.getPaisDeTarjeta();
        int ejercitoAIncorporar = 0;

        if(this.paisesConquistados.contains(paisDeTarjeta) && this.tarjetas.contains(tarjeta))
            ejercitoAIncorporar = tarjeta.activarTarjeta();
        addEjercito(ejercitoAIncorporar);
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

    public void moverEjercito(Pais paisOrigen, Pais paisDestino, int cantidadTropas) throws MoverEjercitoException {
        if(!paisOrigen.getPaisesLimitrofes().contains(paisDestino)) {
            String exceptionType = "NoLimitrofe";
            throw new MoverEjercitoException(exceptionType);
        }
        if(paisOrigen.getEjercitoActual() < cantidadTropas){
            String exceptionType = "TropasInsuficientes";
            throw new MoverEjercitoException(exceptionType);
        }
        if(!this.getPaisesConquistados().contains(paisOrigen) || !this.getPaisesConquistados().contains(paisDestino)) {
            String exceptionType = "PaisNoMePertenece";
            throw new MoverEjercitoException(exceptionType);
        }
        if(paisOrigen.getEjercitoActual() <= cantidadTropas){
            String exceptionType = "TropasInsuficientes";
            throw new MoverEjercitoException(exceptionType);
        }

        if(paisOrigen.getEjercitoActual() > cantidadTropas) {
            paisOrigen.reducirEjercito(cantidadTropas);
            paisDestino.agregarEjercito(cantidadTropas);
        }
    }

    public void realizarAtaques(){
        if(this.estaVivo()) {
            //acciones
        }
    }

    public void realizarColocacionDeEjercitos() {
        if(this.estaVivo()) {
            //acciones
        }
    }

    public void setObjetivo(Objetivo objetivo) {
        this.objetivo = objetivo;
    }

    public Objetivo getObjetivo(){
        return this.objetivo;
    }

    public boolean esGanador(){return this.objetivo.cumplido();} // se fija si cumple objetivos

}
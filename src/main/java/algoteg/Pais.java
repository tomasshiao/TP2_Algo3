package algoteg;

public class Pais {

    String nombre;
    int cantidadEjercito;

    public Pais(String nombre){
        this.nombre = nombre;
        cantidadEjercito = 0;
    }

    public void agregarEjercito(int cantidad){
        cantidadEjercito += cantidad;
    }

    public void reducirEjercito(int cantidad){
        cantidadEjercito -= cantidad;
    }

    public int getEjercitoActual(){
        return this.cantidadEjercito;
    }

    public String getNombre(){ return this.nombre;}

    public boolean noTengoTropas(){
        return (this.cantidadEjercito == 0);
    }
    private void conquistar(){
        if(this.noTengoTropas()){
            this.agregarEjercito(1);
        }
    }

    public void ocupar(Pais paisDefensor){
        paisDefensor.conquistar();
    }
}
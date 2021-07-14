package algoteg;

public class Tarjeta {
    private String nombrePais;
    private String dibujo;

    public Tarjeta(String nombrePais, String dibujo){
        this.nombrePais = nombrePais;
        this.dibujo = dibujo;
    }

    public String getNombrePais(){
        return nombrePais;
    }

    public String getDibujo(){
        return dibujo;
    }


    public boolean compararTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2){
        boolean comparacion1 = this.getDibujo().equals(tarjeta1.getDibujo());
        boolean comparacion2 = this.getDibujo().equals(tarjeta2.getDibujo());
        boolean comparacion3 = tarjeta1.getDibujo().equals(tarjeta2.getDibujo());

        if(comparacion1 && comparacion2 && comparacion3)
            return true;
        else return !comparacion1 && !comparacion2 && !comparacion3;
    }
}

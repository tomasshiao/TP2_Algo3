package algoteg;

public class Tarjeta {
    private String nombrePais;
    private String dibujo;
    private boolean activada;
    private Pais pais;

    public Tarjeta(Pais pais, String dibujo){
        //this.nombrePais = nombrePais;
        this.dibujo = dibujo;
        this.activada = false;
        this.pais = pais;
    }
    public Tarjeta(String nombrePais, String dibujo){
        this.nombrePais = nombrePais;
        this.dibujo = dibujo;
    }

    public Pais getPaisDeTarjeta(){
        return this.pais;
    }

    public String getDibujo(){
        return dibujo;
    }


    public boolean compararTarjetas(Tarjeta tarjeta1, Tarjeta tarjeta2){
        boolean comparacion1 = this.getDibujo().equals(tarjeta1.getDibujo());
        boolean comparacion2 = this.getDibujo().equals(tarjeta2.getDibujo());
        boolean comparacion3 = tarjeta1.getDibujo().equals(tarjeta2.getDibujo());

        if(comparacion1 && comparacion2 && comparacion3) {
            this.desactivarTarjeta();
            tarjeta1.desactivarTarjeta();
            tarjeta2.desactivarTarjeta();
            return true;
        }
        else  if (!comparacion1 && !comparacion2 && !comparacion3){
            this.desactivarTarjeta();
            tarjeta1.desactivarTarjeta();
            tarjeta2.desactivarTarjeta();
            return true;
        }
        return false;
    }

    public int activarTarjeta(){
        int ejercitoAIncorporar = 0;
        if(!this.activada) {
            this.activada = true;
            ejercitoAIncorporar = 2;
        }
        return ejercitoAIncorporar;
    }

    private void desactivarTarjeta(){
        this.activada = false;
    }

    public boolean getActivada(){
        return activada;
    }

    public String getNombrePais(){
        return this.nombrePais;
    }

}
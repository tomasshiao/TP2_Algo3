package algoteg.Exceptions;

public class PaisNoLePerteneceAlJugador extends Exception{
    private final String message = "País de la tarjeta no te pertenece.";

    public PaisNoLePerteneceAlJugador(){
    }

    public String getMessage(){
        return this.message;
    }
}

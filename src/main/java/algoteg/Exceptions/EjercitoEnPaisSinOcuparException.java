package algoteg.Exceptions;

public class EjercitoEnPaisSinOcuparException extends Exception{
    private final String message = "El país en el que quiso poner ejércitos no está ocupado";
    public EjercitoEnPaisSinOcuparException(){

    }
    public String getMessage(){
        return this.message;
    }
}

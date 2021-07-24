package algoteg.Exceptions;

public class ContinenteInexistenteException extends Exception{
    private String message = "El continente buscado no existe";

    public ContinenteInexistenteException(){

    }

    public String getMessage(){
        return this.message;
    }
}
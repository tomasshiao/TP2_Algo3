package algoteg.Exceptions;

public class MoverEjercitoException extends Exception{
    private String message;

    public MoverEjercitoException(String exceptionType){
        switch(exceptionType){
            case "NoLimitrofe":
                message = "No se puede mover tropas a un país que no es límitrofe.";
                break;
            case "TropasInsuficientes":
                message = "No puede mover esa cantidad de tropas.";
                break;
            case "PaisNoMePertenece":
                message = "No puede mover tropas a un país que no le pertenece.";
                break;
            default:
                message = "";
                break;
        }

    }

    public String getMessage(){
        return this.message;
    }
}
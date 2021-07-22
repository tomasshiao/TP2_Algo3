package algoteg.Exceptions;

public class AtaqueInvalidoException extends Exception{
    private String message;

    public AtaqueInvalidoException(String exceptionType){
        switch(exceptionType){
            case "NoLimitrofe":
                message = "No se puede atacar a un país que no es límitrofe.";
                break;
            case "TropasInsuficientes":
                message = "No tiene tropas suficientes para atacar.";
                break;
            case "PaisNoMePertenece":
                message = "No puede atacar desde un país que no le pertenece.";
                break;
            case "ConquistarPaisPropio":
                message = "No puede conquistar un país que ya le pertenece.";
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

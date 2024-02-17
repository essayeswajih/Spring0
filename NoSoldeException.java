public class NoSoldeException extends Exception{
    public NoSoldeException() {}
    public NoSoldeException(String message) {
        super(message);
    }
    public String toString(){
        return "Solde insuffisant !!!";
    }
}
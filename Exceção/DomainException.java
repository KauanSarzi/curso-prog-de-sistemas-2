public class DomainException extends Exception {

    private static final long serialVersionUID = 1L;
    public DomainException(String msg){
        super(msg); // permite que eu possa instanciar minha exceção personalizada passando uma mensagem para ela
    }
    
}



//runtime nao obriga a tratar
//exception o compilador obriga a tratar
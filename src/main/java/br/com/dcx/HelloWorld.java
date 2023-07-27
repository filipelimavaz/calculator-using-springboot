package br.com.dcx;

public class HelloWorld {

    private final long id;
    private final String mensagem;

    public HelloWorld(long id, String mensagem) {
        this.id = id;
        this.mensagem = mensagem;
    }

    public long getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }
}

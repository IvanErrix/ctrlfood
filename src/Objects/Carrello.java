package Objects;

public class Carrello {

    public Carrello(int idcarrello, boolean pagato) {
		super();
		this.idcarrello = idcarrello;
		this.pagato = pagato;
	}
    
    private int idcarrello;
	private boolean pagato; 

	public int getIdcarrello() {
		return idcarrello;
	}

	public void setIdcarrello(int idcarrello) {
		this.idcarrello = idcarrello;
	}

	public boolean isPagato() {
		return pagato;
	}

	public void setPagato(boolean pagato) {
		this.pagato = pagato;
	}
}
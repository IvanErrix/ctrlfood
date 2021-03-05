package Objects;

public class Deposito {
    
	public Deposito(int iddeposito, String indirizzo, String grandezza) {
		super();
		this.iddeposito = iddeposito;
		this.indirizzo = indirizzo;
		this.grandezza = grandezza;
	}

	private int iddeposito;
    private String indirizzo;
    private String grandezza;
    
	public int getIddeposito() {
		return iddeposito;
	}
	
	public void setIddeposito(int iddeposito) {
		this.iddeposito = iddeposito;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getGrandezza() {
		return grandezza;
	}
	
	public void setGrandezza(String grandezza) {
		this.grandezza = grandezza;
	}
}
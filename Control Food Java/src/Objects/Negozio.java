package Objects;

public class Negozio {
	
	public Negozio(int idnegozio, String nome, String indirizzo, String grandezza) {
		super();
		this.idnegozio = idnegozio;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.grandezza = grandezza;
	}

	private int idnegozio;
    private String nome;
    private String indirizzo;
    private String grandezza;
    
	public int getIdnegozio() {
		return idnegozio;
	}
	
	public void setIdnegozio(int idnegozio) {
		this.idnegozio = idnegozio;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
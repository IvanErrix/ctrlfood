package Objects;

public class Cliente {

    public Cliente(int idcliente, String nome, String cognome, String codice_fiscale) {
		super();
		this.idcliente = idcliente;
		this.nome = nome;
		this.cognome = cognome;
		this.codice_fiscale = codice_fiscale;
	}
	private int idcliente;
    private String nome;
    private String cognome;
    private String codice_fiscale;
    
	public int getIdcliente() {
		return idcliente;
	}
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

}
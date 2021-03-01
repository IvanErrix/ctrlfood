package Objects;

public class Negozio {
	
    public Negozio(int idnegozio, String nome, String luogo, int grandezza) {
		super();
		this.idnegozio = idnegozio;
		this.nome = nome;
		this.luogo = luogo;
		this.grandezza = grandezza;
	}
	private int idnegozio;
    private String nome;
    private String luogo;
    private int grandezza;
    
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
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public int getGrandezza() {
		return grandezza;
	}
	public void setGrandezza(int grandezza) {
		this.grandezza = grandezza;
	}


}
package Objects;

import java.util.*;

public class Deposito {

    public Deposito(int iddeposito, String luogo, int grandezza) {
		super();
		this.iddeposito = iddeposito;
		this.luogo = luogo;
		this.grandezza = grandezza;
	}
    
	private int iddeposito;
    private String luogo;
    private int grandezza;
    
	public int getIddeposito() {
		return iddeposito;
	}
	public void setIddeposito(int iddeposito) {
		this.iddeposito = iddeposito;
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
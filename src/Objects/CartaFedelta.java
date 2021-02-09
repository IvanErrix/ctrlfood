package Objects;

import java.util.*;

import Main.Controller;

public class CartaFedelta{

    public CartaFedelta(int idcarta_fedelta, int punti, Date data, int chiave_cliente) {
		super();
		this.idcarta_fedelta = idcarta_fedelta;
		this.punti = punti;
		this.data = data;
		this.chiave_cliente = chiave_cliente;
	}
	private int idcarta_fedelta;
    private int punti = 0;
    private Date data;
    private int chiave_cliente;
    
	public int getIdcarta_fedelta() {
		return idcarta_fedelta;
	}
	
	public void setIdcarta_fedelta(int idcarta_fedelta) {
		this.idcarta_fedelta = idcarta_fedelta;
	}
	
	public int getPunti() {
		return punti;
	}
	
	public void setPunti(int punti) {
		this.punti = punti;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getChiave_cliente() {
		return chiave_cliente;
	}
	
	public void setChiave_cliente(int chiave_cliente) {
		this.chiave_cliente = chiave_cliente;
	}
    
}
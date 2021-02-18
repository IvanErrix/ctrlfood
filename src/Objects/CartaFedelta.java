package Objects;

import java.util.*;

public class CartaFedelta{

    public CartaFedelta(int idcartafedelta, double punti, double puntiortofrutta, double puntilatticini,
			double puntifarinacei, double puntiuova, double punticonfezionati, Date data, int chiavecliente) {
		super();
		this.idcartafedelta = idcartafedelta;
		this.punti = punti;
		this.puntiortofrutta = puntiortofrutta;
		this.puntilatticini = puntilatticini;
		this.puntifarinacei = puntifarinacei;
		this.puntiuova = puntiuova;
		this.punticonfezionati = punticonfezionati;
		this.data = data;
		this.chiavecliente = chiavecliente;
	}
    
    private int idcartafedelta;
	private double punti = 0;
    private double puntiortofrutta = 0;
    private double puntilatticini = 0;
    private double puntifarinacei = 0;
    private double puntiuova = 0;
    private double punticonfezionati = 0;
    private Date data;
    private int chiavecliente;
    
	public int getIdcartafedelta() {
		return idcartafedelta;
	}
	
	public void setIdcartafedelta(int idcarta_fedelta) {
		this.idcartafedelta = idcarta_fedelta;
	}
	
	public double getPunti() {
		return punti;
	}
	
	public void setPunti(double punti) {
		this.punti = punti;
	}
	
	public double getPuntiortofrutta() {
		return puntiortofrutta;
	}
	
	public void setPuntiortofrutta(double punti_ortofrutta) {
		this.puntiortofrutta = punti_ortofrutta;
	}
	
	public double getPuntilatticini() {
		return puntilatticini;
	}
	
	public void setPuntilatticini(double punti_latticini) {
		this.puntilatticini = punti_latticini;
	}
	
	public double getPuntifarinacei() {
		return puntifarinacei;
	}
	
	public void setPuntifarinacei(double punti_farinacei) {
		this.puntifarinacei = punti_farinacei;
	}
	
	public double getPuntiuova() {
		return puntiuova;
	}
	
	public void setPuntiuova(double punti_uova) {
		this.puntiuova = punti_uova;
	}
	
	public double getPunticonfezionati() {
		return punticonfezionati;
	}
	
	public void setPunticonfezionati(double punti_confezionati) {
		this.punticonfezionati = punti_confezionati;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getChiavecliente() {
		return chiavecliente;
	}
	
	public void setChiavecliente(int chiave_cliente) {
		this.chiavecliente = chiave_cliente;
	}
    
}
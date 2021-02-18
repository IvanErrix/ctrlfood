package Objects;

import java.util.*;

public class CartaFedelta{

    public CartaFedelta(int idcarta_fedelta, double punti, double punti_ortofrutta, double punti_latticini,
			double punti_farinacei, double punti_uova, double punti_confezionati, Date data, int chiave_cliente) {
		super();
		this.idcarta_fedelta = idcarta_fedelta;
		this.punti = punti;
		this.punti_ortofrutta = punti_ortofrutta;
		this.punti_latticini = punti_latticini;
		this.punti_farinacei = punti_farinacei;
		this.punti_uova = punti_uova;
		this.punti_confezionati = punti_confezionati;
		this.data = data;
		this.chiave_cliente = chiave_cliente;
	}
    
    private int idcarta_fedelta;
	private double punti = 0;
    private double punti_ortofrutta = 0;
    private double punti_latticini = 0;
    private double punti_farinacei = 0;
    private double punti_uova = 0;
    private double punti_confezionati = 0;
    private Date data;
    private int chiave_cliente;
    
	public int getIdcarta_fedelta() {
		return idcarta_fedelta;
	}
	
	public void setIdcarta_fedelta(int idcarta_fedelta) {
		this.idcarta_fedelta = idcarta_fedelta;
	}
	
	public double getPunti() {
		return punti;
	}
	
	public void setPunti(double punti) {
		this.punti = punti;
	}
	
	public double getPunti_ortofrutta() {
		return punti_ortofrutta;
	}
	
	public void setPunti_ortofrutta(double punti_ortofrutta) {
		this.punti_ortofrutta = punti_ortofrutta;
	}
	
	public double getPunti_latticini() {
		return punti_latticini;
	}
	
	public void setPunti_latticini(double punti_latticini) {
		this.punti_latticini = punti_latticini;
	}
	
	public double getPunti_farinacei() {
		return punti_farinacei;
	}
	
	public void setPunti_farinacei(double punti_farinacei) {
		this.punti_farinacei = punti_farinacei;
	}
	
	public double getPunti_uova() {
		return punti_uova;
	}
	
	public void setPunti_uova(double punti_uova) {
		this.punti_uova = punti_uova;
	}
	
	public double getPunti_confezionati() {
		return punti_confezionati;
	}
	
	public void setPunti_confezionati(double punti_confezionati) {
		this.punti_confezionati = punti_confezionati;
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
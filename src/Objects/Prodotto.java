package Objects;

import java.util.*;

public class Prodotto{

    public Prodotto(int idprodotto, String nome, Double prezzo, int quantita, Date data_scadenza, Boolean ortofrutta,
			Boolean latticino, Boolean farinaceo, Boolean uova, Boolean confezionato, Date data_raccolta,
			Date data_produzione, Date data_mungitura, Date data_deposizione, Date data_confezionamento) {
		
    	super();
		this.idprodotto = idprodotto;
		this.nome = nome;
		this.prezzo = prezzo;
		this.quantita = quantita;
		this.data_scadenza = data_scadenza;
		this.ortofrutta = ortofrutta;
		this.latticino = latticino;
		this.farinaceo = farinaceo;
		this.uova = uova;
		this.confezionato = confezionato;
		this.data_raccolta = data_raccolta;
		this.data_produzione = data_produzione;
		this.data_mungitura = data_mungitura;
		this.data_deposizione = data_deposizione;
		this.data_confezionamento = data_confezionamento;
	}

	private int idprodotto;
    private String nome;
    private Double prezzo;
    private int quantita;
    private Date data_scadenza;
    private Boolean ortofrutta;
    private Boolean latticino;
    private Boolean farinaceo;
    private Boolean uova;
    private Boolean confezionato;
    private Date data_raccolta;
    private Date data_produzione;
    private Date data_mungitura;
    private Date data_deposizione;
    private Date data_confezionamento;
    
	public int getIdprodotto() {
		return idprodotto;
	}
	public void setIdprodotto(int idprodotto) {
		this.idprodotto = idprodotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public Date getData_scadenza() {
		return data_scadenza;
	}
	public void setData_scadenza(Date data_scadenza) {
		this.data_scadenza = data_scadenza;
	}
	public Boolean getOrtofrutta() {
		return ortofrutta;
	}
	public void setOrtofrutta(Boolean ortofrutta) {
		this.ortofrutta = ortofrutta;
	}
	public Boolean getLatticino() {
		return latticino;
	}
	public void setLatticino(Boolean latticino) {
		this.latticino = latticino;
	}
	public Boolean getFarinaceo() {
		return farinaceo;
	}
	public void setFarinaceo(Boolean farinaceo) {
		this.farinaceo = farinaceo;
	}
	public Boolean getUova() {
		return uova;
	}
	public void setUova(Boolean uova) {
		this.uova = uova;
	}
	public Boolean getConfezionato() {
		return confezionato;
	}
	public void setConfezionato(Boolean confezionato) {
		this.confezionato = confezionato;
	}
	public Date getData_raccolta() {
		return data_raccolta;
	}
	public void setData_raccolta(Date data_raccolta) {
		this.data_raccolta = data_raccolta;
	}
	public Date getData_produzione() {
		return data_produzione;
	}
	public void setData_produzione(Date data_produzione) {
		this.data_produzione = data_produzione;
	}
	public Date getData_mungitura() {
		return data_mungitura;
	}
	public void setData_mungitura(Date data_mungitura) {
		this.data_mungitura = data_mungitura;
	}
	public Date getData_deposizione() {
		return data_deposizione;
	}
	public void setData_deposizione(Date data_deposizione) {
		this.data_deposizione = data_deposizione;
	}
	public Date getData_confezionamento() {
		return data_confezionamento;
	}
	public void setData_confezionamento(Date data_confezionamento) {
		this.data_confezionamento = data_confezionamento;
	}
    

}
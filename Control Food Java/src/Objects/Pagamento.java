package Objects;

import java.sql.Date;

public class Pagamento {
	
	public Pagamento(int idpagamento, Date data, int chiavecarrello, int chiavecarta_fedelta) {
		super();
		this.idpagamento = idpagamento;
		this.data = data;
		this.chiavecarrello = chiavecarrello;
		this.chiavecarta_fedelta = chiavecarta_fedelta;
	}

	private int idpagamento;
	private Date data;
	private int chiavecarrello;
	private int chiavecarta_fedelta;
	
	public int getIdpagamento() {
		return idpagamento;
	}
	
	public void setIdpagamento(int idpagamento) {
		this.idpagamento = idpagamento;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public int getChiavecarrello() {
		return chiavecarrello;
	}
	
	public void setChiavecarrello(int chiavecarrello) {
		this.chiavecarrello = chiavecarrello;
	}
	
	public int getChiavecarta_fedelta() {
		return chiavecarta_fedelta;
	}
	
	public void setChiavecarta_fedelta(int chiavecarta_fedelta) {
		this.chiavecarta_fedelta = chiavecarta_fedelta;
	}

}

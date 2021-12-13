package mx.qbits.tienda.api.model.request;

import java.util.Objects;

public class AnuncioRequest {
	private int idCatalogoFormaPago;
	private int idComprador;
	private int id;
	
	public AnuncioRequest() {
	}
	
	public AnuncioRequest(int idCatalogoFormaPago) {
		super();
		this.idCatalogoFormaPago = idCatalogoFormaPago;
	}
	public int getIdCatalogoFormaPago() {
		return idCatalogoFormaPago;
	}

	public void setIdCatalogoFormaPago(int idCatalogoFormaPago) {
		this.idCatalogoFormaPago = idCatalogoFormaPago;
	}

	public int getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(int idComprador){
		this.idComprador= idComprador;
	}

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id=id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(idCatalogoFormaPago);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AnuncioRequest other = (AnuncioRequest) obj;
		return idCatalogoFormaPago == other.idCatalogoFormaPago;
	}

	@Override
	public String toString() {
		return "ProductoRequest [metodoDePago=" + idCatalogoFormaPago + "]";
	}
	
}

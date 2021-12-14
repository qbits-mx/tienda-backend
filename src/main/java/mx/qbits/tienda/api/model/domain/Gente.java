package mx.qbits.tienda.api.model.domain;

import java.util.Objects;

public class Gente {
	private int id;
	private String correo;
	private String clave;
	private long instanteBloqueo;
	
	public Gente () {
		
	}

	public Gente(int id, String correo, String clave, long instanteBloqueo) {
		super();
		this.id = id;
		this.correo = correo;
		this.clave = clave;
		this.instanteBloqueo = instanteBloqueo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public long getInstanteBloqueo() {
		return instanteBloqueo;
	}

	public void setInstanteBloqueo(long instanteBloqueo) {
		this.instanteBloqueo = instanteBloqueo;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + id;
		result = prime * result + (int) (instanteBloqueo ^ (instanteBloqueo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gente other = (Gente) obj;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id != other.id)
			return false;
		if (instanteBloqueo != other.instanteBloqueo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Gente [id=" + id + ", correo=" + correo + ", clave=" + clave + ", instanteBloqueo=" + instanteBloqueo
				+ "]";
	}
	
	
}

package entidade;

import java.io.Serializable;

public class CorpoClinico extends Pessoa implements Serializable {
	private String docCorpoClinico;
	private String especialidade;
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
	public String getDocCorpoClinico() {
		return docCorpoClinico;
	}
	public void setDocCorpoClinico(String docCorpoClinico) {
		this.docCorpoClinico = docCorpoClinico;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
	@Override
    public boolean equals(Object object) {
        if (!(object instanceof CorpoClinico)) {
            return false;
        }
        CorpoClinico other = (CorpoClinico) object;
      
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
	@Override
	public String toString() {
		return "CorpoClinico [docCorpoClinico=" + docCorpoClinico + ", especialidade=" + especialidade + "]";
	}
	
	
}

package biz.lcompras.model;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="FORMAPAGO",
uniqueConstraints={
        @UniqueConstraint(name="FOR_DESCRIPCION_DUPLICADA", columnNames={"DESCRIPCION"})        
})
public class FormaPago extends SuperClaseFeliz  {
	
	@Required
	@Column(length=200,nullable=false,name="DESCRIPCION")	
	private String descripcion ;	
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}

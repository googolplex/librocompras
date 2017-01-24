package biz.lcompras.model;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

//@Entity
@Table(name="RETENCIONES",
uniqueConstraints={
        @UniqueConstraint(name="LCO_ID_DUPLICADO", columnNames={"ID"})
})
public class Retenciones extends SuperClaseFeliz  {
	
	@Required
	@Column(length=15,nullable=false,name="RUC")	
	private String ruc ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="FECHA")	
	private Date fecha ;
	
	@Required
	@Column(length=255,nullable=false,name="FACTURA")	
	private String factura ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTOBASE")	
	private Double montobase ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTOIVA")	
	private Double montoiva ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTOTOTAL")	
	private Double montototal ;
	
	@Required
	@Column(length=5,nullable=false,name="PORCENTAJERET")	
	private Double porcentajeret ;

	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTORET")	
	private Double montoret ;
	
	@Required
	@Column(length=20,nullable=false,name="TOTALRET")	
	private Double totalret ;
	
	@Required
	@Column(length=20,nullable=false,name="NUMEROCOMPROBANTE")	
	private Long numcomprobante ;
	
	@Required
	@Column(length=250,nullable=false,name="RESPONSABLERET")	
	private String responsableret ;
	
	@Required
	@Column(length=20,nullable=false,name="TIMBRADONUMERO")	
	private Long timnumero ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="TIMBRADOHASTA")	
	private Date timhasta ;
	
	
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}

package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

//@Entity
@Table(name="LIBROCOMPRAS",
uniqueConstraints={
        @UniqueConstraint(name="LCO_ID_DUPLICADO", columnNames={"ID"})
})
public class LibroCompras extends SuperClaseFeliz  {
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="LC_FECHA")	
	private Date lcfecha ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_PROVEEDOR_RUC")	
	private String lcproveedorruc ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOEXENTO")	
	private Double lcexento ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_TOTALGRAVADA10")	
	private Double lctotalgravada10 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOIVA10")	
	private Double lcmontoiva10 ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_TOTALGRAVADAS5")	
	private Double lctotalgravadas5 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOIVA5")	
	private Double lcmontoiva5 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOTOTAL")	
	private Double lcmontototal ;
	
	@Required
	@Column(length=10,nullable=false,name="LC_CONTRIBUYENTE")	
	private Long lccontribuyente ;
	
	@Required
	@Column(length=4,nullable=false,name="LC_TIPOIVA")	
	private Long lctipoiva ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOBASE10")	
	private Double lcmontobase10 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOBASE5")	
	private Double lcmontobase5 ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_NUMEROFACTURA")	
	private String lcnumerofactura ;
	
	@Required
	@Column(length=6,nullable=false,name="LC_PERIODO")	
	private Long lcperiodo ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_NROFACT2")	
	private Long lcnrofact2 ;
	
	@Required
	@Column(length=200,nullable=false,name="COMPRASALFA")	
	private String comprasalfa ;
	
	@Required
	@Column(length=200,nullable=false,name="PAGOSALFA")	
	private String pagosalfa ;
	
	@Required
	@Column(length=200,nullable=false,name="CUENTA")	
	private String cuenta ;
	
	@Required
	@Column(length=200,nullable=false,name="CONTRACUENTA")	
	private String contracuenta ;
	
	
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}

package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

//@Entity
@Table(name="LIBROVENTAS",
uniqueConstraints={
        @UniqueConstraint(name="LVE_ID_DUPLICADO", columnNames={"ID"})
})
public class LibroVentas extends SuperClaseFeliz  {
	
	@Required
	@Column(length=200,nullable=false,name="LV_FECHA")	
	private Date lvfecha ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_CLIENTE_RUC")	
	private String lvclienteruc ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOEXENTO")	
	private Long lvexento ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADA10")	
	private Long lvtotalgravada10 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOIVA10")	
	private Long lvmontoiva10 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADAS5")	
	private Long lvtotalgravadas5 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOIVA5")	
	private Long lvmontoiva5 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOTOTAL")	
	private Long lvmontototal ;
	
	@Required
	@Column(length=10,nullable=false,name="LV_CONTRIBUYENTE")	
	private Long lvcontribuyente ;
	
	@Required
	@Column(length=4,nullable=false,name="LV_TIPOIVA")	
	private Long lvtipoiva ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOBASE10")	
	private Long lvmontobase10 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOBASE5")	
	private Long lvmontobase5 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_NUMEROFACTURA")	
	private String lvnumerofactura ;
	
	@Required
	@Column(length=6,nullable=false,name="LV_PERIODO")	
	private Long lvperiodo ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_NROFACT2")	
	private Long lvnrofact2 ;
	
	@Required
	@Column(length=200,nullable=false,name="VENTASALFA")	
	private String ventasalfa ;
	
	@Required
	@Column(length=200,nullable=false,name="COBROSALFA")	
	private String cobrosalfa ;
	
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

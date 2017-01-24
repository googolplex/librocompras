package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

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
	private Date lcFecha ;
	
	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="LC_PROVEEDOR_RUC")	
	private String lcProveedorRuc ;
	
	@Required
	// @Digits(integer=15,fraction=0)
	@Min(0) // para los montos no calculados
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOEXENTO")	
	private Double lcExento ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_TOTALGRAVADA10")	
	private Double lcTotalGravada10 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOIVA10")	
	private Double lcMontoIva10 ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_TOTALGRAVADAS5")	
	private Double lcTotalGravadas5 ;
	
	@Required	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOIVA5")	
	private Double lcMontoIva5 ;
	
	@Required
	// @Digits(integer=15,fraction=0)
	@Min(0) // para los montos no calculados
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOTOTAL")	
	private Double lcMontoTotal ;
	
	@Required
	@Column(length=10,nullable=false,name="LC_CONTRIBUYENTE")	
	private Long lcContribuyente ;
	
	@Required
	@Column(length=4,nullable=false,name="LC_TIPOIVA")	
	private Long lcTipoIva ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOBASE10")	
	private Double lcMontoBase10 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOBASE5")	
	private Double lcMontoBase5 ;
	
	@Required
	@Pattern(regexp="^[0-9]+-+[0-9]+-+[0-9]+$",message="No es un numero tipo FACTURA NNNN-NNNNN-NNNN ")
	@Column(length=20,nullable=false,name="LC_NUMEROFACTURA")	
	private String lcNumeroFactura ;
	
	@Required
	@Column(length=6,nullable=false,name="LC_PERIODO")	
	private Long lcPeriodo ;
	
	@Required
	@Column(length=20,nullable=false,name="LC_NROFACT2")	
	private Long lcNroFact2 ;
	
	@Required
	@Column(length=200,nullable=false,name="COMPRASALFA")	
	private String comprasAlfa ;
	
	@Required
	@Column(length=200,nullable=false,name="PAGOSALFA")	
	private String pagosAlfa ;
	
	@Required
	@Column(length=200,nullable=false,name="CUENTA")	
	private String cuenta ;
	
	@Required
	@Column(length=200,nullable=false,name="CONTRACUENTA")	
	private String contraCuenta ;
	
	
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}

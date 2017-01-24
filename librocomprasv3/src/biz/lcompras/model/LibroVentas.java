package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

//@Entity
@Table(name="LIBROVENTAS",
uniqueConstraints={
        @UniqueConstraint(name="LVE_ID_DUPLICADO", columnNames={"ID"})
})
public class LibroVentas extends SuperClaseFeliz  {
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="LV_FECHA")	
	private Date lvFecha ;
	
	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="LV_CLIENTE_RUC")	
	private String lvClienteRuc ;
	
	@Required
	// @Digits(integer=15,fraction=0)
	@Min(0) // para los montos no calculados
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LV_MONTOEXENTO")	
	private Double lvExento ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADA10")	
	private Double lvTotalGravada10 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LV_MONTOIVA10")	
	private Double lvMontoIva10 ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADAS5")	
	private Double lvTotalGravadas5 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LV_MONTOIVA5")	
	private Double lvMontoIva5 ;
	
	@Required
	// @Digits(integer=15,fraction=0)
	@Min(0) // para los montos no calculados
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LV_MONTOTOTAL")	
	private Double lvMontoTotal ;
	
	@Required
	@Column(length=10,nullable=false,name="LV_CONTRIBUYENTE")	
	private Long lvContribuyente ;
	
	@Required
	@Column(length=4,nullable=false,name="LV_TIPOIVA")	
	private Long lvTipoIva ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LV_MONTOBASE10")	
	private Double lvMontoBase10 ;
	
	@Required
	@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LV_MONTOBASE5")	
	private Double lvMontoBase5 ;
	
	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="LV_NUMEROFACTURA")	
	private String lvNumeroFactura ;
	
	@Required
	@Column(length=6,nullable=false,name="LV_PERIODO")	
	private Long lvPeriodo ;
	
	@Required
	@Column(length=20,nullable=false,name="LV_NROFACT2")	
	private Long lvNroFact2 ;
	
	@Required
	@Column(length=200,nullable=false,name="VENTASALFA")	
	private String ventasAlfa ;
	
	@Required
	@Column(length=200,nullable=false,name="COBROSALFA")	
	private String cobrosAlfa ;
	
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

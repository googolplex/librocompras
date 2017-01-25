package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="LIBROCOMPRAS"
      ,uniqueConstraints={
         @UniqueConstraint(name="LCO_FACTURA_DUPLICADA", columnNames={"LC_PERIODO","IDCONTRIB_ID","LC_NROFACT2"})
        }
)
@Tab(properties= "lcPeriodo, lcFecha, contribuyente.cteNombre, proveedor.nombre, lcNumeroFactura, lcMontoTotal, lcMontoIva10+, lcMontoIva5+, lcExento+, tipomov.descripcion, estado.descripcion", defaultOrder="${lcPeriodo} desc,${lcFecha} asc")
public class LibroCompras extends SuperClaseFeliz  {
	
	@DescriptionsList(descriptionProperties="cteNombre",order="${cteNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCONTRIB_ID", referencedColumnName="ID")
	private Contribuyente contribuyente ;
	
	@DescriptionsList(descriptionProperties="nombre",order="${nombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDPROV_ID", referencedColumnName="ID")
	private Proveedor proveedor ;
	
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDTIPOIVA_ID", referencedColumnName="ID")
	private TipoIva tipoiva ;
	
	@DescriptionsList(descriptionProperties="cuenta",condition="((${imputable} = 'S') AND (${codigocuenta} >= 400d) AND (${codigocuenta} <= 499d))")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="COMPRADORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaCompradora ;
	
	@DescriptionsList(descriptionProperties="cuenta",condition="((${imputable} = 'S') AND (${codigocuenta} >= 1010101d) AND (${codigocuenta} <= 1010199d)) OR ((${imputable} = 'S') AND (${codigocuenta} >= 1010301d) AND (${codigocuenta} <= 1010399d))")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="PAGADORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaPagadora ;
	
	@DescriptionsList(descriptionProperties="descripcion",condition="${quelibro}=0")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUTIPOMOV_ID", referencedColumnName="ID")
	private TipoMov tipomov ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUFORMAPAGO_ID", referencedColumnName="ID")
	private FormaPago formapago ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUDEDUCIBLE_ID", referencedColumnName="ID")
	private Deducible deducible ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUESTADO_ID", referencedColumnName="ID")
	private Estado estado ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="LC_FECHA")	
	private Date lcFecha ;
	
	//@Required
	//@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="LC_PROVEEDOR_RUC")
	@ReadOnly
	private String lcProveedorRuc ;
	
	@Required
	// @Digits(integer=15,fraction=0)
	@Min(0) // para los montos no calculados
	//@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="LC_MONTOEXENTO",scale=0)	
	private Double lcExento ;
	
	@Required
	@Min(0)
	@Column(length=20,nullable=false,name="LC_TOTALGRAVADA10",scale=0)	
	private Double lcTotalGravada10 ;
	
	//@Required
	//@Stereotype("MONEY")
	@ReadOnly
	@Column(length=20,nullable=false,name="LC_MONTOIVA10",scale=0)	
	private Double lcMontoIva10 ;
	
	@Required
	@Min(0)
	@Column(length=20,nullable=false,name="LC_TOTALGRAVADAS5",scale=0)	
	private Double lcTotalGravadas5 ;
	
	@Required
	//@Stereotype("MONEY")
	@ReadOnly
	@Column(length=20,nullable=false,name="LC_MONTOIVA5",scale=0)	
	private Double lcMontoIva5 ;
	
	//@Required
	// @Digits(integer=15,fraction=0)
	//@Min(0) // para los montos no calculados
	//@Stereotype("MONEY")
	@ReadOnly
	@Column(length=20,nullable=false,name="LC_MONTOTOTAL",scale=0)	
	private Double lcMontoTotal ;
	
	@Required
	@Column(length=10,nullable=false,name="LC_CONTRIBUYENTE")	
	private Long lcContribuyente ;
	
	@Required
	@Hidden
	@Column(length=4,nullable=false,name="LC_TIPOIVA")	
	private Long lcTipoIva ;
	
	@Required
	@Min(0)
	@Column(length=20,nullable=false,name="LC_MONTOBASE10",scale=0)	
	private Double lcMontoBase10 ;
	
	@Required
	@Min(0)
	@Column(length=20,nullable=false,name="LC_MONTOBASE5",scale=0)	
	private Double lcMontoBase5 ;
	
	@Required
	@Pattern(regexp="^[0-9]+-+[0-9]+-+[0-9]+$",message="No es un numero tipo FACTURA NNNN-NNNNN-NNNN ")
	@Column(length=20,nullable=false,name="LC_NUMEROFACTURA")	
	private String lcNumeroFactura ;
	
	@Required
	@Min(0)
	@Column(length=6,nullable=false,name="LC_PERIODO")	
	private Long lcPeriodo ;
	
	//@Required
	@Hidden
	@Column(length=20,nullable=false,name="LC_NROFACT2")	
	private Long lcNroFact2 ;
	
	//@Required
	@Hidden
	@Column(length=200,nullable=false,name="COMPRASALFA")	
	private String comprasAlfa ;
	
	//@Required
	@Hidden
	@Column(length=200,nullable=false,name="PAGOSALFA")	
	private String pagosAlfa ;
	
	//@Required
	@Hidden
	@Column(length=200,nullable=false,name="CUENTA")	
	private String cuenta ;
	
	//@Required
	@Hidden
	@Column(length=200,nullable=false,name="CONTRACUENTA")	
	private String contraCuenta ;
	
	
	
	public Contribuyente getContribuyente() {
		return contribuyente;
	}



	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}



	public Proveedor getProveedor() {
		return proveedor;
	}



	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}



	public TipoIva getTipoiva() {
		return tipoiva;
	}



	public void setTipoiva(TipoIva tipoiva) {
		this.tipoiva = tipoiva;
	}



	public PlanCuentas getCtaCompradora() {
		return ctaCompradora;
	}



	public void setCtaCompradora(PlanCuentas ctaCompradora) {
		this.ctaCompradora = ctaCompradora;
	}



	public PlanCuentas getCtaPagadora() {
		return ctaPagadora;
	}



	public void setCtaPagadora(PlanCuentas ctaPagadora) {
		this.ctaPagadora = ctaPagadora;
	}



	public TipoMov getTipomov() {
		return tipomov;
	}



	public void setTipomov(TipoMov tipomov) {
		this.tipomov = tipomov;
	}



	public FormaPago getFormapago() {
		return formapago;
	}



	public void setFormapago(FormaPago formapago) {
		this.formapago = formapago;
	}



	public Deducible getDeducible() {
		return deducible;
	}



	public void setDeducible(Deducible deducible) {
		this.deducible = deducible;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public Date getLcFecha() {
		return lcFecha;
	}



	public void setLcFecha(Date lcFecha) {
		this.lcFecha = lcFecha;
	}



	public String getLcProveedorRuc() {
		return lcProveedorRuc;
	}



	public void setLcProveedorRuc(String lcProveedorRuc) {
		this.lcProveedorRuc = lcProveedorRuc;
	}



	public Double getLcExento() {
		return lcExento;
	}



	public void setLcExento(Double lcExento) {
		this.lcExento = lcExento;
	}



	public Double getLcTotalGravada10() {
		return lcTotalGravada10;
	}



	public void setLcTotalGravada10(Double lcTotalGravada10) {
		this.lcTotalGravada10 = lcTotalGravada10;
	}



	public Double getLcMontoIva10() {
		return lcMontoIva10;
	}



	public void setLcMontoIva10(Double lcMontoIva10) {
		this.lcMontoIva10 = lcMontoIva10;
	}



	public Double getLcTotalGravadas5() {
		return lcTotalGravadas5;
	}



	public void setLcTotalGravadas5(Double lcTotalGravadas5) {
		this.lcTotalGravadas5 = lcTotalGravadas5;
	}



	public Double getLcMontoIva5() {
		return lcMontoIva5;
	}



	public void setLcMontoIva5(Double lcMontoIva5) {
		this.lcMontoIva5 = lcMontoIva5;
	}



	public Double getLcMontoTotal() {
		return lcMontoTotal;
	}



	public void setLcMontoTotal(Double lcMontoTotal) {
		this.lcMontoTotal = lcMontoTotal;
	}



	public Long getLcContribuyente() {
		return lcContribuyente;
	}



	public void setLcContribuyente(Long lcContribuyente) {
		this.lcContribuyente = lcContribuyente;
	}



	public Long getLcTipoIva() {
		return lcTipoIva;
	}



	public void setLcTipoIva(Long lcTipoIva) {
		this.lcTipoIva = lcTipoIva;
	}



	public Double getLcMontoBase10() {
		return lcMontoBase10;
	}



	public void setLcMontoBase10(Double lcMontoBase10) {
		this.lcMontoBase10 = lcMontoBase10;
	}



	public Double getLcMontoBase5() {
		return lcMontoBase5;
	}



	public void setLcMontoBase5(Double lcMontoBase5) {
		this.lcMontoBase5 = lcMontoBase5;
	}



	public String getLcNumeroFactura() {
		return lcNumeroFactura;
	}



	public void setLcNumeroFactura(String lcNumeroFactura) {
		this.lcNumeroFactura = lcNumeroFactura;
	}



	public Long getLcPeriodo() {
		return lcPeriodo;
	}



	public void setLcPeriodo(Long lcPeriodo) {
		this.lcPeriodo = lcPeriodo;
	}



	public Long getLcNroFact2() {
		return lcNroFact2;
	}



	public void setLcNroFact2(Long lcNroFact2) {
		this.lcNroFact2 = lcNroFact2;
	}



	public String getComprasAlfa() {
		return comprasAlfa;
	}



	public void setComprasAlfa(String comprasAlfa) {
		this.comprasAlfa = comprasAlfa;
	}



	public String getPagosAlfa() {
		return pagosAlfa;
	}



	public void setPagosAlfa(String pagosAlfa) {
		this.pagosAlfa = pagosAlfa;
	}



	public String getCuenta() {
		return cuenta;
	}



	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}



	public String getContraCuenta() {
		return contraCuenta;
	}


	public void setContraCuenta(String contraCuenta) {
		this.contraCuenta = contraCuenta;
	}

	private void camposCalculados() {
		
	}
	@PrePersist
	private void antesDeGrabar() {
		this.camposCalculados();
	}
	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
			this.camposCalculados();
	}		
	
}

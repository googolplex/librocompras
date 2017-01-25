package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="LIBROVENTAS"
	,uniqueConstraints={
        @UniqueConstraint(name="LVE_FACTURA_DUPLICADA", columnNames={"LV_PERIODO","IDCONTRIB_ID","LV_NROFACT2"})
        }
)
@Tab(properties="lvPeriodo,lvFecha,contribuyente.cteNombre,cliente.cliNombre,lvNumeroFactura,lvMontoTotal+,lvMontoIva10+,lvMontoIva5+,lvExento+,tipomov.descripcion,estado.descripcion",defaultOrder="${lvPeriodo} desc,${lvFecha} asc")
public class LibroVentas extends SuperClaseFeliz  {
	@Required
	@Min(0)
	@Column(length=6,nullable=false,name="LV_PERIODO")	
	private Long lvPeriodo ;	
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="LV_FECHA")	
	private Date lvFecha ;
	
	@DescriptionsList(descriptionProperties="cliNombre",order="${cliNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCLI_ID", referencedColumnName="ID")
	private Cliente cliente ;		
	
	@DescriptionsList(descriptionProperties="cteNombre",order="${cteNombre}")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDCONTRIB_ID", referencedColumnName="ID")
	private Contribuyente contribuyente ;
	
	@DescriptionsList(descriptionProperties="tivacod,tivanombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="IDTIPOIVA_ID", referencedColumnName="ID")
	private TipoIva tipoiva ;

	@DescriptionsList(descriptionProperties="descripcion",condition="${quelibro}=1")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUTIPOMOV_ID", referencedColumnName="ID")
	private TipoMov tipomov ;
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUFORMACOBRO_ID", referencedColumnName="ID")
	private FormaPago formapago ;	
	
	@DescriptionsList(descriptionProperties="cuenta",condition="((${imputable} = 'S') AND (${codigocuenta} >= 1011001d) AND (${codigocuenta} <= 1011099d)) OR ((${imputable} = 'S') AND (${codigocuenta} >= 301d) AND (${codigocuenta} <= 302d)) ")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="VENDEDORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaVendedora ;	
	
	@DescriptionsList(descriptionProperties="cuenta",condition="(${imputable} = 'S') AND (${codigocuenta} >= 1010101d) AND (${codigocuenta} <= 1010199d)")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="COBRADORA_ID", referencedColumnName="ID")
	private PlanCuentas ctaCobradora ;		
	
	@DescriptionsList(descriptionProperties="descripcion")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="TUESTADO_ID", referencedColumnName="ID")
	private Estado estado ;
	
	
	// campo calculado

	// @Required
	// @Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="LV_CLIENTE_RUC")
	@ReadOnly	
	private String lvClienteRuc ;
	
	// @Digits(integer=15,fraction=0)
	@Min(value=0) // para los montos no calculados
	// @Stereotype("MONEY")
	@Required	
	@Column(length=20,nullable=false,name="LV_MONTOEXENTO",scale=0)	
	private Double lvExento ;
	
	@Required
	@Min(0)
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADA10",scale=0)	
	private Double totalGravada10 ;
	
	// campo calculado
	// @Required
	// @Stereotype("MONEY")
	// @Min(0)
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_MONTOIVA10",scale=0)	
	private Double lvMontoIva10 ;
	
	@Min(0)
	@Required
	@Column(length=20,nullable=false,name="LV_TOTALGRAVADAS5",scale=0)	
	private Double totalGravadas5 ;
	
	// campo calculado
	@Required
	// @Min(0)
	// @Stereotype("MONEY")
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_MONTOIVA5",scale=0)	
	private Double lvMontoIva5 ;
	
	// monto calculado
	// @Required
	// @Digits(integer=15,fraction=0)
	// @Min(0) // para los montos no calculados
	// @Stereotype("MONEY")
	@ReadOnly
	@Column(length=20,nullable=false,name="LV_MONTOTOTAL",scale=0)	
	private Double lvMontoTotal ;
	
	@Hidden
	@Column(length=4,nullable=false,name="LV_TIPOIVA")	
	private Long lvTipoIva ;
	
	@Min(0)
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOBASE10",scale=0)	
	private Double lvMontoBase10 ;
	
	@Min(0)
	@Required
	@Column(length=20,nullable=false,name="LV_MONTOBASE5",scale=0)	
	private Double lvMontoBase5 ;
	
	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=20,nullable=false,name="LV_NUMEROFACTURA")	
	private String lvNumeroFactura ;
	
	
	// @Required
	@Hidden
	@Column(length=20,nullable=false,name="LV_NROFACT2")	
	private Long lvNroFact2 ;
	
	//  @Required
	@Hidden
	@Column(length=200,nullable=false,name="VENTASALFA")	
	private String ventasAlfa ;
	
	@Hidden
	@Column(length=200,nullable=false,name="COBROSALFA")	
	private String cobrosAlfa ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CUENTA")	
	private String cuenta ;
	
	@Hidden
	@Column(length=200,nullable=false,name="CONTRACUENTA")	
	private String contraCuenta ;



	public Long getLvPeriodo() {
		return lvPeriodo;
	}



	public void setLvPeriodo(Long lvPeriodo) {
		this.lvPeriodo = lvPeriodo;
	}



	public Date getLvFecha() {
		return lvFecha;
	}



	public void setLvFecha(Date lvFecha) {
		this.lvFecha = lvFecha;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Contribuyente getContribuyente() {
		return contribuyente;
	}



	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}



	public TipoIva getTipoiva() {
		return tipoiva;
	}



	public void setTipoiva(TipoIva tipoiva) {
		this.tipoiva = tipoiva;
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



	public PlanCuentas getCtaVendedora() {
		return ctaVendedora;
	}



	public void setCtaVendedora(PlanCuentas ctaVendedora) {
		this.ctaVendedora = ctaVendedora;
	}



	public PlanCuentas getCtaCobradora() {
		return ctaCobradora;
	}



	public void setCtaCobradora(PlanCuentas ctaCobradora) {
		this.ctaCobradora = ctaCobradora;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado estado) {
		this.estado = estado;
	}



	public String getLvClienteRuc() {
		return lvClienteRuc;
	}



	public void setLvClienteRuc(String lvClienteRuc) {
		this.lvClienteRuc = lvClienteRuc;
	}



	public Double getLvExento() {
		return lvExento;
	}



	public void setLvExento(Double lvExento) {
		this.lvExento = lvExento;
	}





	public Double getTotalGravada10() {
		return totalGravada10;
	}



	public void setTotalGravada10(Double totalGravada10) {
		this.totalGravada10 = totalGravada10;
	}



	public Double getLvMontoIva10() {
		return lvMontoIva10;
	}



	public void setLvMontoIva10(Double lvMontoIva10) {
		this.lvMontoIva10 = lvMontoIva10;
	}




	public Double getTotalGravadas5() {
		return totalGravadas5;
	}



	public void setTotalGravadas5(Double totalGravadas5) {
		this.totalGravadas5 = totalGravadas5;
	}



	public Double getLvMontoIva5() {
		return lvMontoIva5;
	}



	public void setLvMontoIva5(Double lvMontoIva5) {
		this.lvMontoIva5 = lvMontoIva5;
	}



	public Double getLvMontoTotal() {
		return lvMontoTotal;
	}



	public void setLvMontoTotal(Double lvMontoTotal) {
		this.lvMontoTotal = lvMontoTotal;
	}



	public Long getLvTipoIva() {
		return lvTipoIva;
	}



	public void setLvTipoIva(Long lvTipoIva) {
		this.lvTipoIva = lvTipoIva;
	}



	public Double getLvMontoBase10() {
		return lvMontoBase10;
	}



	public void setLvMontoBase10(Double lvMontoBase10) {
		this.lvMontoBase10 = lvMontoBase10;
	}



	public Double getLvMontoBase5() {
		return lvMontoBase5;
	}



	public void setLvMontoBase5(Double lvMontoBase5) {
		this.lvMontoBase5 = lvMontoBase5;
	}



	public String getLvNumeroFactura() {
		return lvNumeroFactura;
	}



	public void setLvNumeroFactura(String lvNumeroFactura) {
		this.lvNumeroFactura = lvNumeroFactura;
	}



	public Long getLvNroFact2() {
		return lvNroFact2;
	}



	public void setLvNroFact2(Long lvNroFact2) {
		this.lvNroFact2 = lvNroFact2;
	}



	public String getVentasAlfa() {
		return ventasAlfa;
	}



	public void setVentasAlfa(String ventasAlfa) {
		this.ventasAlfa = ventasAlfa;
	}



	public String getCobrosAlfa() {
		return cobrosAlfa;
	}



	public void setCobrosAlfa(String cobrosAlfa) {
		this.cobrosAlfa = cobrosAlfa;
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

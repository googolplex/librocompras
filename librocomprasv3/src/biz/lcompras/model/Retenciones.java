package biz.lcompras.model;


import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.openxava.annotations.*;
import org.openxava.util.*;

@Entity
@Table(name="RETENCIONES"
 , uniqueConstraints={
        @UniqueConstraint(name="RET_FACTURA_DUPLICADA", columnNames={"factura"})
        , @UniqueConstraint(name="RET_COMPROBANTE_DUPLICADO", columnNames={"numeroComprobante"})        
 }
)
@Tab(properties="fecha,contribuyente.cteCodigo,cliente.cliNombre,factura,numeroComprobante,montoTotal,totalRet",defaultOrder="fecha")
public class Retenciones extends SuperClaseFeliz  {

	// ejemplo de FOREIGN KEY CONTRIBUYENTE
	@DescriptionsList(descriptionProperties="cteCodigo,cteNombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="CONTRIBUYENTE_ID", referencedColumnName="ID")
	private Contribuyente contribuyente ;
	
	// ejemplo de FOREIGN KEY AGENTE (PROVEEDOR)
	@DescriptionsList(descriptionProperties="cliCodigo,cliNombre")
	@ManyToOne(fetch=FetchType.LAZY,optional=false)	
	@JoinColumn(name="AGENTE_ID", referencedColumnName="ID")
	private Cliente cliente ;	
	
	@Required
	@Pattern(regexp="^[0-9]+-*[0-9]$",message="No es un numero tipo RUC NNNNNNNNN-N ")
	@Column(length=15,nullable=false,name="RUC")	
	private String ruc ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="FECHA")	
	private Date fecha ;
	
	@Required
	@Pattern(regexp="^[0-9]+-+[0-9]+-+[0-9]+$",message="No es un numero tipo FACTURA NNNN-NNNNN-NNNN ")
	@Column(length=255,nullable=false,name="FACTURA")	
	private String factura ;
	
	@Required
	// @Digits(integer=20,fraction=0)
	@Min(0)  // posiblemente para todos los montos que no son calculados
	// @Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTOBASE",scale=0)	
	private Double montoBase ;
	
	@Required
	// @Digits(integer=20,fraction=0)
	//@Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTOIVA",scale=0)	
	private Double montoIva ;
	
	@Required
	// @Digits(integer=20,fraction=0)
	// @Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTOTOTAL",scale=0)	
	private Double montoTotal ;
	
	@Required
	@Min(0)  // posiblemente para todos los montos que no son calculados
	@Max(100)
	// @Digits(integer=5,fraction=0)
	@Column(length=5,nullable=false,name="PORCENTAJERET",scale=2)	
	private Double porcentajeRet ;

	@Required
	// @Digits(integer=20,fraction=0)
	// @Stereotype("MONEY")
	@Column(length=20,nullable=false,name="MONTORET",scale=0)	
	private Double montoRet ;
	
	@Required
	// posiblemente sera un campo calculado (no por ahora)
	// @Digits(integer=15,fraction=0)
	// @Stereotype("MONEY")
	@Column(length=20,nullable=false,name="TOTALRET",scale=0)	
	private Double totalRet ;
	
	@Required
	@Column(length=20,nullable=false,name="NUMEROCOMPROBANTE")	
	private Long numeroComprobante ;
	
	@Required
	@Stereotype("MEMO")
	@Column(length=250,nullable=false,name="RESPONSABLERET")	
	private String responsableRet ;
	
	@Required
	@Column(length=20,nullable=false,name="TIMBRADONUMERO")	
	private Long timbradoNumero ;
	
	@Required
	@Stereotype("DATE")
	@Column(nullable=false,name="TIMBRADOHASTA")	
	private Date timbradoFchHasta ;
	

	
	public Contribuyente getContribuyente() {
		return contribuyente;
	}


	public void setContribuyente(Contribuyente contribuyente) {
		this.contribuyente = contribuyente;
	}



	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public String getRuc() {
		return ruc;
	}


	public void setRuc(String ruc) {
		this.ruc = ruc.toUpperCase().trim();
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getFactura() {
		return factura;
	}


	public void setFactura(String factura) {
		this.factura = factura;
	}


	public Double getMontoBase() {
		return montoBase;
	}


	public void setMontoBase(Double montoBase) {
		this.montoBase = montoBase;
	}


	public Double getMontoIva() {
		return montoIva;
	}


	public void setMontoIva(Double montoIva) {
		this.montoIva = montoIva;
	}


	public Double getMontoTotal() {
		return montoTotal;
	}


	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}


	public Double getPorcentajeRet() {
		return porcentajeRet;
	}


	public void setPorcentajeRet(Double porcentajeRet) {
		this.porcentajeRet = porcentajeRet;
	}


	public Double getMontoRet() {
		return montoRet;
	}


	public void setMontoRet(Double montoRet) {
		this.montoRet = montoRet;
	}


	public Double getTotalRet() {
		return totalRet;
	}


	public void setTotalRet(Double totalRet) {
		this.totalRet = totalRet;
	}


	public Long getNumeroComprobante() {
		return numeroComprobante;
	}


	public void setNumeroComprobante(Long numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}


	public String getResponsableRet() {
		return responsableRet;
	}


	public void setResponsableRet(String responsableRet) {
		this.responsableRet = responsableRet.toUpperCase().trim();
	}


	public Long getTimbradoNumero() {
		return timbradoNumero;
	}


	public void setTimbradoNumero(Long timbradoNumero) {
		this.timbradoNumero = timbradoNumero;
	}


	public Date getTimbradoFchHasta() {
		return timbradoFchHasta;
	}


	public void setTimbradoFchHasta(Date timbradoFchHasta) {
		this.timbradoFchHasta = timbradoFchHasta;
	}


	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}		
	
}

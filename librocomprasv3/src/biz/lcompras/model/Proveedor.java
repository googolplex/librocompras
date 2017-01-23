package biz.lcompras.model;
import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.util.*;
// import com.compufiber.validadores.*;

@Entity
@Table(name="PROVEEDOR",
uniqueConstraints={
        @UniqueConstraint(name="mr_no_repetir_descripcion", columnNames={"descripcion"}),
        @UniqueConstraint(name="mr_no_repetir_codigo", columnNames={"codigo"})
})
public class Proveedor extends SuperClaseFeliz {
	@Required
	@Column(length=20,nullable=false,name="PRV_CODIGO")
	private String codigo ;

	@Required
	@Column(length=80,nullable=false,name="PRV_NOMBRE")	
	private String nombre ;

	@Required
	@Column(length=100,nullable=false,name="PRV_CIUDAD")	
	private String ciudad ;	
	
	@Stereotype("MEMO")
	@Required
	@Column(length=500,nullable=false,name="PRV_DIRECCION")	
	private String direccion ;	

	@Required
	@Column(length=50,nullable=false,name="PRV_TELEFONO1")	
	private String telefono1 ;	

	@Required
	@Column(length=50,nullable=false,name="PRV_TELEFONO2")	
	private String telefono2 ;	
	
	@Required
	@Column(length=50,nullable=false,name="PRV_TELEFONO3")	
	private String telefono3 ;	
	
	@Stereotype("EMAIL")
	@Required
	@Column(length=100,nullable=false,name="PRV_EMAIL")	
	private String email ;	
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo.toUpperCase().trim();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase().trim();
	}
	
	
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion.toUpperCase().trim();
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1.toUpperCase().trim();
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2.toUpperCase().trim();
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3.toUpperCase().trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toUpperCase().trim();
	}

	
	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad.toUpperCase().trim();
	}

	@PreUpdate
	private void ultimoPaso() {
			Date mifechora = new java.util.Date() ;
			super.setModificadoPor(Users.getCurrent()) ;
			super.setFchUltMod(mifechora)  ;
	}	
}
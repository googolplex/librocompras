package biz.lcompras.model;

import java.util.*;

import javax.persistence.*;
import org.hibernate.validator.constraints.*;
import org.openxava.annotations.*;
import org.openxava.calculators.*;
import org.openxava.util.*;

import biz.lcompras.calculadores.*;

@Entity
@Table(name="PERIODOS")
public class Periodos extends SuperClaseFeliz {

@Required
@Range(min=2000,max=9999)
@Column(name="PER_YYYY",length=4,nullable=false)
//@DefaultValueCalculator(CeroFelizLong.class)
@DefaultValueCalculator(CurrentYearCalculator.class)
private Long yyyy ;

@Required
@Range(min=1,max=12)
@Column(name="PER_MM",length=2,nullable=false)
@DefaultValueCalculator(CeroFelizLong.class)
private Long mes ;


public Long getYyyy() {
	return yyyy;
}
public void setYyyy(Long yyyy) {
	this.yyyy = yyyy;
}
public Long getMes() {
	return mes;
}
public void setMes(Long mes) {
	this.mes = mes;
}

@PreUpdate
private void ultimoPaso() {
		Date mifechora = new java.util.Date() ;
		super.setModificadoPor(Users.getCurrent()) ;
		super.setFchUltMod(mifechora)  ;
}
	
}

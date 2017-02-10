package biz.lcompras.acciones;


import java.util.*;
import org.openxava.actions.*;
import net.sf.jasperreports.engine.*;

public class LibroComprasImpresionAction  extends JasperReportBaseAction {

	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		// return new JREmptyDataSource();
		// si le devuelves null se le devuelve la conexion JDBC, para usar el SQL dentro del reporte
		// http://www.openxava.org/OpenXavaDoc/apidocs/org/openxava/actions/JasperReportBaseAction.html#getDataSource()
		return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		// return "/home/xoldfusion/Descargas/librocompras2017/jasperfeliz/prueba3.jrxml" ; // lo leo del file system
		// return "biz/lcompras/informes/prueba3.jrxml"; // lo leo del classpath 
		return "biz/lcompras/informes/librocompraspg3.jrxml"; // lo leo del classpath
	}

	@Override
	protected Map<String,String> getParameters() throws Exception {
		Map<String,String> parametros = new HashMap<String,String>() ;
		// yo creo que no se va a usar porque tengo la clase donde pongo los parametros
		parametros.put("p_yyyymm","201701");
		parametros.put("p_contribuyente","581069");
		return parametros ;
	}

	
	
/*	public Collection<VistaLibroCompras> getRenglones() {
		if (renglones == null ) {
			renglones = XPersistence.getManager().createQuery("from VistaLibroCompras").getResultList();
		}
		return renglones;
	}*/


	
	
}

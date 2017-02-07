package biz.lcompras.acciones;


import java.util.*;

import javax.servlet.*;

import org.apache.commons.fileupload.*;
import org.openxava.actions.*;

import net.sf.jasperreports.engine.*;

public class LibroComprasImpresionAction  extends JasperReportBaseAction {

	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return new JREmptyDataSource();
		// return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		// return "Prueba3.jrxml"; // lo leo del classpath 
		return "/home/xoldfusion/Descargas/librocompras2017/jasperfeliz/prueba3.jrxml" ; // lo leo del file system
	}

	@Override
	protected Map getParameters() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

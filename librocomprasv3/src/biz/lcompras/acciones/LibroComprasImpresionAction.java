package biz.lcompras.acciones;

import java.util.*;

import org.openxava.actions.*;

import net.sf.jasperreports.engine.*;

public class LibroComprasImpresionAction  extends JasperReportBaseAction {

	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		// TODO Auto-generated method stub
		return "/informes/librocompraspg.jrxml"; // lo leo del classpath
	}

	@Override
	protected Map getParameters() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}

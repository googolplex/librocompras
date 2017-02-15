package biz.lcompras.acciones;


import java.sql.*;
import java.util.*;
import org.openxava.actions.*;
import org.openxava.util.*;

import biz.lcompras.beansfelices.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;
import org.apache.commons.dbutils.BeanProcessor;


public class LibroComprasImpresionAction  extends JasperReportBaseAction {


	Connection con = null ;
	
	@Override
	protected JRDataSource getDataSource() throws Exception {
		// return new JREmptyDataSource();
		// si le devuelves null se le devuelve la conexion JDBC, para usar el SQL dentro del reporte
		// http://www.openxava.org/OpenXavaDoc/apidocs/org/openxava/actions/JasperReportBaseAction.html#getDataSource()
		
		// String table = MetaModel.get("InvoiceDetail").getMapping().getTable();
		// porque no es una tabla
		try {
		con = DataSourceConnectionProvider.getByComponent("Periodos").getConnection();		
		PreparedStatement ps = con.prepareStatement("select * from vista_librocompras k order by tipomov, lc_fecha");
		ResultSet rs = ps.executeQuery();
		BeanProcessor bp = new BeanProcessor();
		ArrayList<VistaLibroComprasBean> list = new ArrayList<VistaLibroComprasBean>();		
		while(rs.next()) {
			list.add((VistaLibroComprasBean) bp.toBean(rs, VistaLibroComprasBean.class));
		}
        rs.close();
        ps.close();
        // solo para debug
        
        // for(VistaLibroComprasBean mb : list){
        //    System.out.println(mb.getLc_numerofactura());
        // }        
        
		} catch (Exception e ){
			e.printStackTrace();
		}
		
		return null;
	}

	public void execute() throws Exception {
		super.execute();
		addMessage("Impresion del Libro");
	}	
	
	
	@Override
	protected String getJRXML() throws Exception {
		// return "/home/xoldfusion/Descargas/librocompras2017/jasperfeliz/prueba3.jrxml" ; // lo leo del file system
		// return "biz/lcompras/informes/prueba3.jrxml"; // lo leo del classpath 
		return "biz/lcompras/informes/librocompraspg3.jrxml"; // lo leo del classpath
	}

	@Override
	protected Map<String, Object> getParameters() throws Exception {
		JRFileVirtualizer virtualizer = new JRFileVirtualizer(2, "/tmp");
				
		Map<String, Object> parametros = new HashMap<String, Object>() ;
		parametros.put(JRParameter.REPORT_VIRTUALIZER, virtualizer);

//		parametros.put(JRParameter.REPORT_CONNECTION, con );
		
		// yo creo que no se va a usar porque tengo la clase donde pongo los parametros
		// parametros.put("p_yyyymm","201701");
		// parametros.put("p_contribuyente","581069");
		// parametros.put("REPORT_CONNECTION", "jdbc:postgresql://52.207.31.88:5432/manzanas?user=manzanas&password=googolplex124abc");
		//		return null ;
		return parametros ;
	}

	
	
/*	public Collection<VistaLibroCompras> getRenglones() {
		if (renglones == null ) {
			renglones = XPersistence.getManager().createQuery("from VistaLibroCompras").getResultList();
		}
		return renglones;
	}*/


	
	
}

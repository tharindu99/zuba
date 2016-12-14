package lsf.zuba.main;

import java.util.ArrayList;

import lsf.zuba.javacc.SyntaxChecker;
import lsf.zuba.vizobj.ChartParameter;

public class zuba_main {
	

	public static void main(String[] args) {			 
			 
		String zuba_query = "DRAW CHART bar TO mydiv FOR {Select a,b from c;} WHICH X:a, Y:b";
		
		 try {
	            ChartParameter chart_obj = new SyntaxChecker(new java.io.StringReader(zuba_query)).Visualization();
	            System.out.println("Syntax is okay");
	            System.out.println("result : "+chart_obj.getBindTo());

	            //New code segment for extract the SQL part
				String sql = zuba_query.substring(zuba_query.indexOf("{")+1,zuba_query.indexOf("}"));
				System.out.println("SQL: " +sql);
				
	            //System.out.println("result : "+chart_obj.getX().getData_parameter());
	        } catch (Throwable e) {
	            // Catching Throwable is ugly but JavaCC throws Error objects!
	            System.out.println("Syntax check failed: " + e.getMessage());
	        }

	}

}

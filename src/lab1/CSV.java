package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class CSV {

	public static void writeFile(String name, ArrayList<Result> array) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(name));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
		sb.append("iteration");
        sb.append('-');
        sb.append("returns");
        sb.append('-');
        sb.append("time");
        sb.append('\n');
        for(Result r : array) {
        	sb.append(r.getIteration());
            sb.append('-');
        	sb.append(r.getReturns());
            sb.append('-');
        	sb.append(r.getTime());
            sb.append('\n');
        }
		
		pw.write(sb.toString());
	    pw.close();
	}
	
	public static void writeFileSimple( String name, long time) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new File(name));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		sb.append("name");
        sb.append('\n');
        sb.append("time:" + time + " ms");
        sb.append('\n');
//		for(int g : array) {
//			sb.append(g);
//	        sb.append('\n');
//		}
		pw.flush();
		pw.write(sb.toString());
	    pw.close();
	}
}
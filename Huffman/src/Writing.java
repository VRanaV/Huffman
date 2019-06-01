import java.io.*;
import java.lang.*;
import java.util.*;
import java.io.BufferedWriter;

public class Writing {
    private Formatter x;
    private Formatter y;
    private Formatter z;
    //private Formatter result2;
    public void OpenFile() {
    	try {
    		
    		x= new Formatter("Compression.txt");
    		
    	}
    	catch(Exception e) {
    		
    		System.out.println("Error");
    	}
    	
    }
    public void AddRecord(String in) {
    	x.format("%s", in);
    }
    public void CloseFile() {
    	x.close();
    }
    ////////////////////////////////////////
    
    public void OpenFile2() {
    	try {
    		FileWriter g= new FileWriter("Table.txt",true);
    		z= new Formatter(g);
    		
    	}
    	catch(Exception e) {
    		
    		System.out.println("Error");
    	}
    	
    }
    public void AddRecord2(char n,String in) {
    	

    	z.format("%s%s%s%s", n,",",in,",");
    	
    	
    }
    public void CloseFile2() {
    	z.close();
    }
    /////////////////////////////////
   ////////////////////////////
    public void OpenFileAgain() {
    	try {
    		y= new Formatter("StreamResult.txt");
    		
    	}
    	catch(Exception e) {
    		
    		System.out.println("Error");
    	}
    	
    }
    public void AddRecordAgain(String in) {
    	y.format("%s", in);
    }
    public void CloseFileAgain() {
   y.close();
    }
    
}

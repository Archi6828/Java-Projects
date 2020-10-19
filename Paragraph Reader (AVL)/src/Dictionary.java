import java.net.*;
import java.io.*;
import java.util.*;

public class Dictionary {
	private String savedWord; 
	public Dictionary(String word) {
			//website
		    String host = "dict.org";
	    try {
	    	//hosts the website
	    	savedWord = "";
	        Socket soc = new Socket(host,2628);
	        OutputStream out = soc.getOutputStream();
	        String request = "DEFINE ! " + word;
	        out.write(request.getBytes());
	        out.flush();
	        soc.shutdownOutput();
	        //input HERE
	        InputStream in = soc.getInputStream();
	        Scanner input = new Scanner(in);
	        String whole = "";
			while( input.hasNext() )
				whole+= input.nextLine() + "\n";
			int x = 2;
	        //System.out.print( whole );
	        //scans in the items pulled from the database
	        if( !(whole.contains(" 1. ") || whole.contains(" 2. ")) ) {
	        	savedWord = whole;
	        }
	        else {
	        	Scanner s = new Scanner(whole);
	        	while( s.hasNextLine() ) {
	        		String temp = s.nextLine();
		        	if( (temp.contains(" 1. ") || temp.contains(" 2. ")) && x > 0) {
		        		savedWord += temp + '\n';
		        		x--;
		        		while( temp.charAt(temp.length()-1) != '.') {
		        			temp = s.nextLine();
		        			savedWord += temp + '\n';
		        		}
		        		//prints out the first two options for each one because all of them are too long
		        	}
	        	}
	        	
	        }
	        
	        
	        soc.close();}
		    	 catch (UnknownHostException e) {
		        System.out.println("Cannot find the host at "+host);
		    } catch (IOException e) {
		        e.printStackTrace();
		    } 
		}
	public String getSavedWord()
	{
		return savedWord;
	}
	
//	public String getParagraph()
//	{
//		String ans = "";
//		Scanner input = new Scanner(in);
//		while( input.hasNext() )
//			ans+= input.nextLine() + "\n";
//		return ans;
//	}
//	public  String toString() {
//		int x = 2;
//        String whole = getParagraph();
//        String output = "";
//        //System.out.print( whole );
//        //scans in the items pulled from the database
//        if( !(whole.contains(" 1. ") || whole.contains(" 2. ")) ) {
//        	return whole;
//        }
//        else {
//        	Scanner s = new Scanner(whole);
//        	while( s.hasNextLine() ) {
//        		String temp = s.nextLine();
//	        	if( (temp.contains(" 1. ") || temp.contains(" 2. ")) && x > 0) {
//	        		output += temp + '\n';
//	        		x--;
//	        		while( temp.charAt(temp.length()-1) != '.') {
//	        			temp = s.nextLine();
//	        			output += temp + '\n';
//	        		}
//	        		//prints out the first two options for each one because all of them are too long
//	        	}
//        	}
//        	
//        }
//        return output;
//       
//    }
	
}
	

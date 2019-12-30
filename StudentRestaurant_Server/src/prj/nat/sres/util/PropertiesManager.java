package prj.nat.sres.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropertiesManager {
	
	public String propertiesImportToCurrentFileName(String fileName) throws Exception {

		try (FileInputStream fis = new FileInputStream(fileName);
				BufferedReader br = new BufferedReader(new InputStreamReader((fis),"UTF8"));)
		{            
			Properties props = new Properties();
			props.load(br);
			
			String currentFileName = props.getProperty("currentFileName");			
		
			return currentFileName;
			
		}	catch(Exception e)    {throw e;}      
	}
	
	public void propertiesExport(Properties props, String fileName) throws Exception {

		try(FileWriter fw = new FileWriter(fileName);
                BufferedWriter br = new BufferedWriter(fw)){
			
			props.store(br, "comm");
                
        }catch(Exception e) {}    
	}
}

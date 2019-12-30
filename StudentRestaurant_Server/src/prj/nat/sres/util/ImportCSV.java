package prj.nat.sres.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import prj.nat.sres.dto.Menu;

public class ImportCSV {
	
	public List<Menu> menuImport(String fileName) throws Exception {
		
		try (    FileInputStream fis = new FileInputStream(fileName);
                BufferedReader br = new BufferedReader(new InputStreamReader((fis),"UTF8"));)
        {            
            String line;
            List<Menu> list = new ArrayList<>();           
            
            int i = 1;
            while ( ( line = br.readLine() ) != null ) {
            	if(i++ != 1) {
            		String category = line.split(",")[0];
                	String menuName = line.split(",")[1];
                	int price = Integer.parseInt(line.split(",")[2]);
                	int quantity = Integer.parseInt(line.split(",")[3]);
                	
                	list.add(new Menu(category, menuName, price, quantity));
            	} else {
            		continue;
            	}
            	
            }
            
            return list;
        }
        catch(Exception e)    {throw e;}      
	}
}

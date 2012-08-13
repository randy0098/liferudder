/*
 * Copyright Notice ====================================================
 * This file contains proprietary information of SNS.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2010   All rights reserved. ======================
 */

package menus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class MenuReader {

	public static List<Module> read() {
		JAXBContext jc;
		List<Module> moduleList = null;
		try {
			jc = JAXBContext.newInstance("menus");
			Unmarshaller u = jc.createUnmarshaller();
			Modules modules = (Modules)u.unmarshal(new FileInputStream("src/main/resources/menus.xml"));
			moduleList = modules.getModule();
			return moduleList;

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moduleList;
	}

	/**
	 * Description goes here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package menus;

 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import menus.Menu;
import menus.Menus;
import menus.Module;
import menus.Modules;
 
public class MenusReadTest {
	
	public static void readMenuTest(){
        try {
            // create a JAXBContext capable of handling classes generated into
            JAXBContext jc = JAXBContext.newInstance( "menus" );
            
            // create an Unmarshaller
            Unmarshaller u = jc.createUnmarshaller();
            
            // unmarshal a po instance document into a tree of Java content
            // objects composed of classes from the primer.po package.
//            JAXBElement<?> poElement = 
            
            //menus.xml location?
            Modules modules = (Modules) u.unmarshal( new FileInputStream( "src/main/resources/menus.xml" ));
            
            List<Module> list = modules.getModule();
            for(int i=0; i<list.size(); i++){
            	Module module = list.get(i);
            	System.out.println("module start---------------");
            	System.out.println("module name:" + module.getName());
            	List<Menus> menus = module.getMenus();
            	for(int j=0; j<menus.size(); j++){
            		Menus oneMenus = menus.get(j);
            		System.out.println("menus start################");
            		System.out.println("menus name:" + oneMenus.getName());
            		List<Menu> menu = oneMenus.getMenu();
            		for(int k=0; k<menu.size(); k++){
            			Menu oneMenu = menu.get(k);
            			System.out.println("menu name:" + oneMenu.getName());
            			System.out.println("menu href:" + oneMenu.getHref());
            		}
            		System.out.println("menus end################");
            	}
            	System.out.println("module end---------------");
            }
        } catch( JAXBException je ) {
            je.printStackTrace();
        } catch( IOException ioe ) {
            ioe.printStackTrace();
        }
	}
	
    public static void main( String[] args ) {
    	readMenuTest();
    }
    
}

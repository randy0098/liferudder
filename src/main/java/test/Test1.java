package test;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add( "first" );
		list.add( "second" );
		JSONArray jsonArray2 = JSONArray.fromObject( list );
		System.out.println(jsonArray2);
	}

}

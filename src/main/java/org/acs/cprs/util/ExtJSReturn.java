package org.acs.cprs.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.acs.cprs.model.AcademicInstitution;
import org.springframework.stereotype.Component;

//import br.com.braziljs.loiane.model.Contact;

/**
 * Util class, returns a Map in the format Ext JS expects
 * 
 * Sample project presented at BrazilJS
 * Brazilian JavaScript Conference
 * Fortaleza - Ceará - 13-14 May 2011
 * http://braziljs.com.br/2011
 * 
 * @author Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */
@Component
public class ExtJSReturn {

	/**
	 * Generates modelMap to return in the modelAndView
	 * @param objs
	 * @return
	 */
	public static Map<String,Object> mapOK(List objs){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", objs.size());
		modelMap.put("data", objs);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView
	 * @param objs
	 * @return
	 */
	public static Map<String,Object> mapOK(List objs, int total){
		
		Map<String,Object> modelMap = new HashMap<String,Object>(3);
		modelMap.put("total", total);
		modelMap.put("data", objs);
		modelMap.put("success", true);
		
		return modelMap;
	}
	
	/**
	 * Generates modelMap to return in the modelAndView in case
	 * of exception
	 * @param msg message
	 * @return
	 */
	public static Map<String,Object> mapError(String msg){

		Map<String,Object> modelMap = new HashMap<String,Object>(2);
		modelMap.put("message", msg);
		modelMap.put("success", false);

		return modelMap;
	}

}

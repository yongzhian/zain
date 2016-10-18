package cn.zain.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明：Java对象序列化为JSON工具类。
 * @author Frank
 */
public class JsonSerializeUtils {

	private static final Logger logger = LogManager.getLogger(JsonSerializeUtils.class);

	private static ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 功能说明：将JSON字符串反序列号化为对象。
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T deserialize(String json, Class<T> clazz) {

		if (null == clazz || String.class.equals(clazz)) {
			return (T) json;
		}

		Object object = null;
		try {
			object = objectMapper.readValue(json, TypeFactory.rawClass(clazz));
		} catch (JsonParseException e) {
			logger.error("JsonParseException when serialize object to json.json : " + json, e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException when serialize object to json .json : " + json,
					e);
		} catch (IOException e) {
			logger.error("IOException when serialize object to json.json : " + json, e);
		}
		return (T) object;
	}

	/**
	 * 功能说明：将对象序列号化为JSON字符串。
	 * @param object
	 * @return
	 */
	public static String serialize(Object object) {

		if(null == object) {
			return null;
		}
		
		if (object instanceof String) {
			return (String) object;
		}

		Writer write = new StringWriter();

		try {
			objectMapper.writeValue(write, object);
		} catch (JsonGenerationException e) {
			logger.error(
					"JsonGenerationException when serialize object to json", e);
		} catch (JsonMappingException e) {
			logger.error("JsonMappingException when serialize object to json",
					e);
		} catch (IOException e) {
			logger.error("IOException when serialize object to json", e);
		}

		return write.toString();
	}
	
	/**
	 * 将json对象转换为java集合对象
	 * json格式:
	 * [{"robot_sn":"HRCF10310100000071408150XX"},{"robot_sn":"HRCF10310100000071408151XX"}]
	 * @param clazz
	 * @param jsons
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> List<T> transJsonObj2Collection(T clazz, String jsons) {
		if(StringUtils.isBlank(jsons)){
			return null;
		}
        List<T> objs=null;
        JSONArray jsonArray=(JSONArray)JSONSerializer.toJSON(jsons);
        if(jsonArray!=null){
            objs=new ArrayList<T>();
            List list=(List)JSONSerializer.toJava(jsonArray);
            for(Object o:list){
                JSONObject jsonObject=JSONObject.fromObject(o);
                T obj=(T)JSONObject.toBean(jsonObject, clazz.getClass());
                objs.add(obj);
            }
        }
        return objs;
    }
	
	/**
	 * 将json串转换为字符串数组
	 * json格式:
	 * ["HRCF10310100000071408150XX","HRCF10310100000071408151XX"]
	 * @param jsons
	 * @return
	 */
	public static Object[] transJsonArr2StrArr(String jsons) {
		if(StringUtils.isBlank(jsons)){
			return null;
		}
        try {
			JSONArray jArray=JSONArray.fromObject(jsons);
			return jArray.toArray();
		} catch (Exception e) {
			logger.error("转换jsons为Object[]失败，jsons :" + jsons, e);
		}
		return null;
    }
	
	/**
	 * 将java集合对象转换为json
	 * @param collection
	 * @return
	 */
	public static <T> String transCollection2Json(List<T> collection) {
        return JSONArray.fromObject(collection).toString();
    }
	
}
    

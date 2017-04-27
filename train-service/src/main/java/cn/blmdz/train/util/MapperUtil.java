package cn.blmdz.train.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * json、参数、object 等 工具类
 */
public class MapperUtil {
	
	public static final ObjectMapper mapper;
	static {
		mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}
	
	static JavaType javaType= mapper.constructType(LinkedHashMap.class);
	
	public static <T> LinkedHashMap<Object, Object> convertLinkedMap(T t) {
		return mapper.convertValue(t, javaType);
	}
	
	/**
	 * 适用于结构简单的参数返回
	 */
	public static <T> String convertParams(T t) {
		StringBuilder sb = new StringBuilder();
		for (Entry<Object, Object> entry : convertLinkedMap(t).entrySet()) {
			sb.append(entry.getKey())
			.append("=")
			.append(entry.getValue())
			.append("&");
		}
		if (sb.length() != 0) {
			return sb.substring(0, sb.length() - 1);
		}
		return "";
	}
}
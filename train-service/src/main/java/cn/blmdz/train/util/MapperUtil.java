package cn.blmdz.train.util;

import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

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
}
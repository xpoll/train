package cn.blmdz.train.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

public class RequestUtil {

	public static <T> void getNoBack(String url, T t) {
		try {
			HttpsUtil.get().execute(new HttpGet(url + "?" + (t == null ? "" : MapperUtil.convertParams(t))));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T, E> T get(String url, E t, Class<T> clazz) {
		try {
			HttpEntity entity = HttpsUtil.get()
				.execute(new HttpGet(url + "?" + (t == null ? "" : MapperUtil.convertParams(t))))
				.getEntity();
			return MapperUtil.mapper.readValue(EntityUtils.toString(entity), clazz);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}

package cn.blmdz.train.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

public class RequestUtil {
	
	public static <T> void getNoResponse(String url, T t) {
		try {
			url = url + (t == null ? "" : "?" + MapperUtil.convertParams(t));
			HttpEntity entity = HttpsUtil.get().execute(new HttpGet(url)).getEntity();
			returnStr(entity, url, "get");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T, E> T get(String url, E t, Class<T> clazz) {
		try {
			url = url + (t == null ? "" : "?" + MapperUtil.convertParams(t));
			HttpEntity entity = HttpsUtil.get().execute(new HttpGet(url)).getEntity();
			// 验证码处理
			if (clazz == InputStream.class) {
				return (T) entity.getContent();
			}
			return MapperUtil.mapper.readValue(returnStr(entity, url, "get"), clazz);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> void postNoResponse(String url, T t) {
		try {
			HttpPost post = new HttpPost(url);
			List<NameValuePair> list = Lists.newArrayList();
			for (Entry<Object, Object> entry : MapperUtil.convertLinkedMap(t).entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
			}
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpEntity entity = HttpsUtil.get().execute(post).getEntity();
			returnStr(entity, url, "post");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> void postNoResponse(String url, List<NameValuePair> list) {
		try {
			HttpPost post = new HttpPost(url);
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpEntity entity = HttpsUtil.get().execute(post).getEntity();
			returnStr(entity, url, "post");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static <T, E> T post(String url, E t, Class<T> clazz) {
		try {
			HttpPost post = new HttpPost(url);
			List<NameValuePair> list = Lists.newArrayList();
			for (Entry<Object, Object> entry : MapperUtil.convertLinkedMap(t).entrySet()) {
				list.add(new BasicNameValuePair(entry.getKey().toString(), entry.getValue().toString()));
			}
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpEntity entity = HttpsUtil.get().execute(post).getEntity();
			return MapperUtil.mapper.readValue(returnStr(entity, url, "post"), clazz);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T, E> T post(String url, List<NameValuePair> list, Class<T> clazz) {
		try {
			HttpPost post = new HttpPost(url);
			post.setEntity(new UrlEncodedFormEntity(list));
			HttpEntity entity = HttpsUtil.get().execute(post).getEntity();
			return MapperUtil.mapper.readValue(returnStr(entity, url, "post"), clazz);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String returnStr(HttpEntity entity, String url, String methods) throws ParseException, IOException {
		String response = EntityUtils.toString(entity);
		System.out.println(methods + ": " + url);
		if (!url.equals(ConsUtil.loginInit)) {
			System.out.println("response:" + response);
		}
		return response;
	}
}

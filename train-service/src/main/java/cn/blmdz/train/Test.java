package cn.blmdz.train;

import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.common.collect.Lists;

import lombok.Data;

public class Test {

	public static void main(String[] args) throws IOException {
//		request.trustAllCerts();
//		request.trustAllHosts();
		
		CloseableHttpClient client = HttpClients.createDefault();
		
		HttpPost post = new HttpPost("https://kyfw.12306.cn/otn/czxx/queryByTrainNo");
		List<NameValuePair> list = Lists.newArrayList();
		list.add(new BasicNameValuePair("train_no", "2400000G4307"));
		list.add(new BasicNameValuePair("from_station_telecode", "VNP"));
		list.add(new BasicNameValuePair("to_station_telecode", "AOH"));
		list.add(new BasicNameValuePair("depart_date", "2017-04-27"));
		HttpEntity entity = new UrlEncodedFormEntity(list);
		post.setEntity(entity);
		CloseableHttpResponse response = client.execute(post);
		entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));
	}
}
@Data
class GG {
//	GG gg = new GG();
//	gg.setTo_station_telecode("AOH");
//	gg.setDepart_date("2017-04-27");
//	gg.setFrom_station_telecode("VNP");
//	gg.setTrain_no("2400000G4307");
	private String train_no;
	private String from_station_telecode;
	private String to_station_telecode;
	private String depart_date;
}

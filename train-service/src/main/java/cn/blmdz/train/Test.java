package cn.blmdz.train;

import java.io.IOException;

import cn.blmdz.train.model.req.StopByRequest;
import cn.blmdz.train.model.res.StopByResponse;
import cn.blmdz.train.util.HttpsUtil;
import cn.blmdz.train.util.RequestUtil;

public class Test {

	public static void main(String[] args) throws IOException {
		String url = "https://kyfw.12306.cn/otn/czxx/queryByTrainNo";
		HttpsUtil.init();
		
		StopByRequest gg = new StopByRequest();
		gg.setTo_station_telecode("AOH");
		gg.setDepart_date("2017-04-27");
		gg.setFrom_station_telecode("VNP");
		gg.setTrain_no("2400000G4307");
		
		StopByResponse res = RequestUtil.get(url, gg, StopByResponse.class);
		
		System.out.println(res.toString());
	}
}

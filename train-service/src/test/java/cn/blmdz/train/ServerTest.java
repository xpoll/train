package cn.blmdz.train;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;

import com.google.common.collect.Lists;

import cn.blmdz.train.model.enums.VerityEnum;
import cn.blmdz.train.model.req.StopByRequest;
import cn.blmdz.train.model.req.VerifyCodeRequest;
import cn.blmdz.train.model.res.LoginResponse;
import cn.blmdz.train.model.res.StopByResponse;
import cn.blmdz.train.model.res.VerityResponse;
import cn.blmdz.train.util.ConsUtil;
import cn.blmdz.train.util.HttpsUtil;
import cn.blmdz.train.util.RequestUtil;

public class ServerTest {

	static {
		HttpsUtil.init();
	}
	
//	@Test
	public void stopBy() {
		StopByRequest req = new StopByRequest();
		req.setTo_station_telecode("AOH");
		req.setDepart_date("2017-04-27");
		req.setFrom_station_telecode("VNP");
		req.setTrain_no("2400000G4307");
		
		StopByResponse res = RequestUtil.get(ConsUtil.stopBy, req, StopByResponse.class);
		System.out.println(res.toString());
	}

	/**
	 * 启动后您有15秒的时间去启动[verify.html]识别验证码并将结果替换至[verify.txt]
	 * 验证码成功后才能后续测试
	 */
//	@Test
	public void verify() throws IOException, InterruptedException {
		VerifyCodeRequest req1 = new VerifyCodeRequest(VerityEnum.Login);
		
		BufferedImage img = ImageIO.read(RequestUtil.get(ConsUtil.getVerify, req1, InputStream.class));
		ImageIO.write(img, "png", new File("verify.png"));
		
		System.out.println("验证码已生成, 您有15秒的时间去启动[verify.html]识别验证码并将结果替换至[verify.txt]");
		Thread.sleep(15000);
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream("verify.txt"));
		BufferedReader br = new BufferedReader(isr);
		String randCode = br.readLine();
		isr.close();
		br.close();

		VerifyCodeRequest req = new VerifyCodeRequest(VerityEnum.Login, randCode);
		VerityResponse res = RequestUtil.get(ConsUtil.verifyCode, req, VerityResponse.class);
		System.out.println(res.toString());
		if ("1".equals(res.getData().getResult())) {
			System.out.println("验证码测试通过");
		} else {
			System.out.println("验证码测试失败:" + res.getData().getMsg());
		}
	}
	
	@Test
	public void login() throws Exception {
		VerifyCodeRequest req1 = new VerifyCodeRequest(VerityEnum.Login);
		// 登陆需请求初始化登陆一次-否则登陆报系统忙异常
		RequestUtil.getNoResponse("https://kyfw.12306.cn/otn/login/init", null);
		
		BufferedImage img = ImageIO.read(RequestUtil.get(ConsUtil.getVerify, req1, InputStream.class));
		ImageIO.write(img, "png", new File("verify.png"));
		
		System.out.println("验证码已生成, 您有15秒的时间去启动[verify.html]识别验证码并将结果替换至[verify.txt]");
		Thread.sleep(15000);
		
		InputStreamReader isr = new InputStreamReader(new FileInputStream("verify.txt"));
		BufferedReader br = new BufferedReader(isr);
		String randCode = br.readLine();
		isr.close();
		br.close();
		
		// 必须验证一下验证码并且通过-否则登陆报系统忙异常
		VerifyCodeRequest req = new VerifyCodeRequest(VerityEnum.Login, randCode);
		VerityResponse res = RequestUtil.post(ConsUtil.verifyCode, req, VerityResponse.class);
		System.out.println(res.toString());
		if ("1".equals(res.getData().getResult())) {
			System.out.println("验证码校验通过");
		} else {
			System.out.println("验证码校验失败:" + res.getData().getMsg());
			throw new Exception("验证码校验失败");
		}

		List<NameValuePair> list = Lists.newArrayList();
		list.add(new BasicNameValuePair("loginUserDTO.user_name", "adfasdf"));
		list.add(new BasicNameValuePair("userDTO.password", "wefwafaf"));
		list.add(new BasicNameValuePair("randCode", randCode));
		LoginResponse loginres = RequestUtil.post(ConsUtil.login, list, LoginResponse.class);
		if (loginres.getMessages().length == 0 && loginres.getData().getLoginCheck().equals("Y")) {
			System.out.println("登陆成功");
		} else if (loginres.getMessages().length == 0) {
			System.out.println("登陆失败:" + loginres.getData().getLoginCheck() + "," + loginres.getData().getOtherMsg());
			throw new Exception("登陆失败");
		} else {
			System.out.println("登陆失败:" + loginres.getMessages()[0]);
			throw new Exception("登陆失败");
		}
		System.out.println(loginres.toString());
	}
}

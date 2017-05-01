package cn.blmdz.train.service.impl;

import java.io.InputStream;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.google.common.collect.Lists;

import cn.blmdz.train.model.base.BasePage;
import cn.blmdz.train.model.req.VerifyCodeRequest;
import cn.blmdz.train.model.res.LoginResponse;
import cn.blmdz.train.model.res.PartnerResponse;
import cn.blmdz.train.model.res.VerityResponse;
import cn.blmdz.train.service.UserService;
import cn.blmdz.train.util.ConsUtil;
import cn.blmdz.train.util.GlobalException;
import cn.blmdz.train.util.RequestUtil;

public class UserServiceImpl implements UserService {

	@Override
	public void login(String name, String password, String randCode) {
		// 登陆需请求初始化登陆一次-否则登陆报系统忙异常
		RequestUtil.getNoResponse(ConsUtil.loginInit, null);
		
		List<NameValuePair> list = Lists.newArrayList();
		list.add(new BasicNameValuePair("loginUserDTO.user_name", name));
		list.add(new BasicNameValuePair("userDTO.password", password));
		list.add(new BasicNameValuePair("randCode", randCode));
		
		LoginResponse loginres = RequestUtil.post(ConsUtil.login, list, LoginResponse.class);
		
		if (loginres.getMessages().length == 0 && loginres.getData().getLoginCheck().equals("Y")) {
			System.out.println("登陆成功");
		} else if (loginres.getMessages().length == 0) {
			System.out.println("登陆失败:" + loginres.getData().getLoginCheck() + "," + loginres.getData().getOtherMsg());
			throw new GlobalException(loginres.getData().getLoginCheck() + "," + loginres.getData().getOtherMsg());
		} else {
			System.out.println("登陆失败:" + loginres.getMessages()[0]);
			throw new GlobalException(loginres.getMessages()[0].toString());
		}
		throw new GlobalException("登陆返回异常");
	}

	@Override
	public void loginout() {
		RequestUtil.getNoResponse(ConsUtil.loginout, null);
	}

	@Override
	public PartnerResponse partner(BasePage page) {
		return RequestUtil.post(ConsUtil.partner, new BasePage(), PartnerResponse.class);
	}

	@Override
	public boolean verifyCode(VerifyCodeRequest request) {

		VerityResponse res = RequestUtil.get(ConsUtil.verifyCode, request, VerityResponse.class);
		if ("1".equals(res.getData().getResult())) {
			System.out.println("验证码测试通过");
			return true;
		}
		System.out.println("验证码测试失败:" + res.getData().getMsg());
		return false;

	}

	@Override
	public InputStream getVerify(VerifyCodeRequest request) {
		return RequestUtil.get(ConsUtil.getVerify, request, InputStream.class);
	}

}

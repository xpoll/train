package cn.blmdz.train.service;

import java.io.InputStream;

import cn.blmdz.train.model.base.BasePage;
import cn.blmdz.train.model.req.VerifyCodeRequest;
import cn.blmdz.train.model.res.PartnerResponse;

/**
 * 用户相关服务
 */
public interface UserService {

	/**
	 * 登陆
	 * 
	 * 验证登录前请确保验证码ok, 否则登陆报[系统忙异常]
	 */
	void login(String name, String password, String randCode);
	
	/**
	 * 登出
	 */
	void loginout();
	
	/**
	 * 联系人
	 */
	PartnerResponse partner(BasePage page);

	/**
	 * 校验验证码
	 */
	boolean verifyCode(VerifyCodeRequest request);

	/**
	 * 获取验证码
	 */
	InputStream getVerify(VerifyCodeRequest request);
}

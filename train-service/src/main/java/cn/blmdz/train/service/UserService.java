package cn.blmdz.train.service;

public interface UserService {

	/**
	 * 登陆
	 */
	void login();
	
	/**
	 * 登出
	 */
	void loginout();
	
	/**
	 * 联系人
	 */
	void partner();

	/**
	 * 检查用户登录是否有效
	 */
	void checkUser();

	/**
	 * 校验验证码
	 */
	void verifyCode();

	/**
	 * 获取验证码
	 */
	void getCode();
}

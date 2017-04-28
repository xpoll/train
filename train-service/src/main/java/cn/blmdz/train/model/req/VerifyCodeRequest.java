package cn.blmdz.train.model.req;

import cn.blmdz.train.model.enums.VerityEnum;
import lombok.Getter;

@Getter
public class VerifyCodeRequest {

	/**
	 * 获取验证码
	 */
	public VerifyCodeRequest(VerityEnum type) {
		if (type.name().equals(VerityEnum.Login.name())) {
			module = "login";
			rand = "sjrand";
		} else {
			module = "other";
			rand = "randp";
		}
		p = Math.random();
	}
	
	/**
	 * 校验验证码
	 */
	public VerifyCodeRequest(VerityEnum type, String randCode) {
		if (type.name().equals(VerityEnum.Login.name())) {
			rand = "sjrand";
		} else {
			rand = "randp";
		}
		this.randCode = randCode;
	}
	
	private String module;
	private Double p;
	
	private String rand;
	private String randCode;
}

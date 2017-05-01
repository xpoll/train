package cn.blmdz.train.model.res.body;

import lombok.Data;

/**
 * 常用联系人
 */
@Data
public class PartnerResponseBody {
	/**
	 * 序号
	 */
	private String code;
	/**
	 * 姓名
	 */
	private String passenger_name;
	/**
	 * 性别code
	 */
	private String sex_code;
	/**
	 * 性别名称
	 */
	private String sex_name;
	/**
	 * 出生日期
	 */
	private String born_date;
	/**
	 * 国籍
	 */
	private String country_code;
	/**
	 * 证件类型编码
	 */
	private String passenger_id_type_code;
	/**
	 * 证件类型名称
	 */
	private String passenger_id_type_name;
	/**
	 * 证件号
	 */
	private String passenger_id_no;
	/**
	 * 证件类型
	 */
	private String passenger_type;
	/**
	 * 	核验状态
	 */
	private String passenger_flag;
	/**
	 * 	旅客类型
	 */
	private String passenger_type_name;
	/**
	 * 手机号码
	 */
	private String mobile_no;
	/**
	 * 固定电话
	 */
	private String phone_no;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String postalcode;
	/**
	 * 名称首字母
	 */
	private String first_letter;
	/**
	 * 记录计数
	 */
	private String recordCount;
	/**
	 * 是自己[Y/N]
	 */
	private String isUserSelf;
	private String total_times;
}

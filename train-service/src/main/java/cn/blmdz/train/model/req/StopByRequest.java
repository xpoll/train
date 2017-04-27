package cn.blmdz.train.model.req;

import lombok.Data;

/**
 * 列车经停站 -->请求实体
 */
@Data
public class StopByRequest{
	
	/**
	 * 车号[2400000G4307]
	 */
	private String train_no;
	/**
	 * from[VNP]
	 */
	private String from_station_telecode;
	/**
	 * to[AOH]
	 */
	private String to_station_telecode;
	/**
	 * 日期[2017-04-27]
	 */
	private String depart_date;
}

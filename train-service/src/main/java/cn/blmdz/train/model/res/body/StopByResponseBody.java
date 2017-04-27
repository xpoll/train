package cn.blmdz.train.model.res.body;

import cn.blmdz.train.model.res.StopByResponse;
import lombok.Data;

/**
 * 列车经停站 -->实体类<br>
 * 粘合见 {@link StopByResponse}
 */
@Data
public class StopByResponseBody {

	/**
	 * 开始站名称
	 */
	private String start_station_name;
	/**
	 * 到达时间
	 */
	private String arrive_time;
	/**
	 * 车次
	 */
	private String station_train_code;
	/**
	 * 站名称
	 */
	private String station_name;
	/**
	 * 车类型名称
	 */
	private String train_class_name;
	/**
	 * 服务类型 TODO
	 */
	private String service_type;
	/**
	 * 发车时间
	 */
	private String start_time;
	/**
	 * 停车时间
	 */
	private String stopover_time;
	/**
	 * 结束站名称
	 */
	private String end_station_name;
	/**
	 * 序号
	 */
	private String station_no;
	/**
	 * 是否经过
	 */
	private Boolean isEnabled;
}

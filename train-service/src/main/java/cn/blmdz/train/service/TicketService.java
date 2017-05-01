package cn.blmdz.train.service;

import java.util.List;

import cn.blmdz.train.model.req.StopByRequest;
import cn.blmdz.train.model.res.body.StopByResponseBody;

/**
 * 票务相关服务
 */
public interface TicketService {

	/**
	 * 查询余票
	 * TODO
	 */
	void extraTicket();
	
	/**
	 * 查询余票价格
	 * TODO
	 */
	void extraTicketPrice();
	
	/**
	 * 查询列车经停站
	 */
	List<StopByResponseBody> stopBy(StopByRequest request);
}

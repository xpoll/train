package cn.blmdz.train.service;

public interface TicketService {

	/**
	 * 查询余票
	 */
	void extraTicket();
	
	/**
	 * 查询列车经停站
	 */
	void stopBy();
}

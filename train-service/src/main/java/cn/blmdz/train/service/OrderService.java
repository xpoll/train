package cn.blmdz.train.service;

public interface OrderService {

	/**
	 * 预提交订单
	 */
	void preparation();

	/**
	 * 检查订单有效
	 */
	void check();

	/**
	 * 获取余票
	 */
	void extra();

	/**
	 * 提交订单 结束
	 */
	void commit();

	/**
	 * 获取排队
	 */
	void queue();

	/**
	 * 取消订单
	 */
	void cancel();

	/**
	 * 查询订单
	 */
	void query();

	/**
	 * 查询未完成订单
	 */
	void queryByUndone();

}

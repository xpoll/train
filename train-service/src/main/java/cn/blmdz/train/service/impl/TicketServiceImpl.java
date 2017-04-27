package cn.blmdz.train.service.impl;

import java.util.List;

import cn.blmdz.train.model.req.StopByRequest;
import cn.blmdz.train.model.res.body.StopByResponseBody;
import cn.blmdz.train.service.TicketService;
import cn.blmdz.train.util.HttpsUtil;

public class TicketServiceImpl implements TicketService {

	public TicketServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void extraTicket() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<StopByResponseBody> stopBy(StopByRequest request) {
		HttpsUtil.get();
		return null;
	}

}

package cn.blmdz.train.service.impl;

import java.util.List;

import cn.blmdz.train.model.req.StopByRequest;
import cn.blmdz.train.model.res.StopByResponse;
import cn.blmdz.train.model.res.body.StopByResponseBody;
import cn.blmdz.train.service.TicketService;
import cn.blmdz.train.util.ConsUtil;
import cn.blmdz.train.util.RequestUtil;

public class TicketServiceImpl implements TicketService {

	@Override
	public void extraTicket() {
		// TODO Auto-generated method stub

	}

	@Override
	public void extraTicketPrice() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StopByResponseBody> stopBy(StopByRequest request) {

		return RequestUtil.get(ConsUtil.stopBy, request, StopByResponse.class).getData().getData();
	}

}

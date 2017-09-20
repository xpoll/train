package cn.blmdz.train.model.res.body;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ExtraTicketResponseBody {

	private List<String> result;
	private String flag;
	private Map<String, String> map;
}

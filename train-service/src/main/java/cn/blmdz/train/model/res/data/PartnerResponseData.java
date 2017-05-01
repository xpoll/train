package cn.blmdz.train.model.res.data;

import java.util.List;

import cn.blmdz.train.model.res.body.PartnerResponseBody;
import lombok.Data;

@Data
public class PartnerResponseData{
	
	private List<PartnerResponseBody> datas;
	
	private Boolean flag;
	/**
	 * 总页数
	 */
	private Integer pageTotal;
}

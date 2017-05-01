package cn.blmdz.train.model.res.data;

import java.util.List;

import cn.blmdz.train.model.res.body.StopByResponseBody;
import lombok.Data;

/**
 * 经停站
 */
@Data
public class StopByResponseData{
	
	private List<StopByResponseBody> data;
}

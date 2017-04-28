package cn.blmdz.train.model.base;

import java.util.List;

import cn.blmdz.train.model.res.StopByResponse;
import lombok.Data;

/**
 * <pre>
 *  此实体为数据返回的 data
 * <pre>
 * {@link BaseResponse#getData()}
 */
@Data
public class BaseResponseData<E>{
	/**
	 * use by
	 * <pre>
	 *  1. 经停站  {@link StopByResponse}
	 * 
	 * </pre>
	 */
	private List<E> data;
	
}

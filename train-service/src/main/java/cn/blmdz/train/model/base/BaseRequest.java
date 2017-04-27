package cn.blmdz.train.model.base;

import cn.blmdz.train.util.MapperUtil;

/**
 * 数据请求
 * <pre>
 *  继承此类的参数须有特定的顺序（官网的某些原因），
 *  请勿乱调整顺序，避免造成请求失败
 * </pre>
 */
@Deprecated
public class BaseRequest {
	@Override
	public String toString() {
		return "?" + MapperUtil.convertParams(this);
	}
}

package cn.blmdz.train.model.base;

import lombok.Data;

/**
 * 数据返回
 */
@Data
public class BaseResponse<T> {
	private String validateMessagesShowId;
	private Boolean status;
	private Integer httpstatus;
	private Object[] messages;
	private T data;
	private Object validateMessages;
}

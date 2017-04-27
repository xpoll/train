package cn.blmdz.train.model;

import java.util.List;

import lombok.Data;

@Data
public class BaseModel<T> {
	private String validateMessagesShowId;
	private Boolean status;
	private Integer httpstatus;
	private Object[] messages;
	private List<T> date;
	private Object validateMessages;
}

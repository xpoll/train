package cn.blmdz.train.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasePage {
	
	private int pageIndex = 1;
	private int pageSize = 10;
}

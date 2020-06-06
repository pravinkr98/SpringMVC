package com.ps.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PagingCommand {

	private int pageNo=1;
	private int pageSize;
}

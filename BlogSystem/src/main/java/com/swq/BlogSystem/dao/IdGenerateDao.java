package com.swq.BlogSystem.dao;

import com.swq.BlogSystem.pojo.IdDto;

public interface IdGenerateDao {
	
	public boolean createId(IdDto idDto);
	
	public IdDto getId(String id);
	
	public boolean updateIdGenerate(IdDto idDto);
}

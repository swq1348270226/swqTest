package com.swq.BlogSystem.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.swq.BlogSystem.dao.IdGenerateDao;
import com.swq.BlogSystem.dao.UserDao;
import com.swq.BlogSystem.pojo.Cart;
import com.swq.BlogSystem.pojo.CartDto;
import com.swq.BlogSystem.pojo.IdDto;
import com.swq.BlogSystem.pojo.User;
import com.swq.BlogSystem.util.StringUtils;

@Component
public class IdGenerateBusiness {
	@Autowired
	IdGenerateDao idGenerateDao;
	
	public boolean createId(IdDto idDto) {
		if(idDto == null || StringUtils.isBlank(idDto.getPrefix()) || idDto.getLength() <= 0 ) {
			return false;
		}
		String prefix = idDto.getPrefix();
		if(getId(prefix) == null) {
			StringBuffer value = new StringBuffer("1");
			if(StringUtils.isBlank(idDto.getValue())) {
				for(int i = 0;i<idDto.getLength()-1;i++ ) {
					value.append("0");
				}
				idDto.setValue(value.toString());
			}
			
			boolean result = idGenerateDao.createId(idDto);
			return result;
		}
		return false;
	}
	
	public IdDto getId(String id) {
		IdDto idDto = new IdDto();
		if(StringUtils.isBlank(id)) {
			return idDto;
		}
		 idDto = idGenerateDao.getId(id);
		 return idDto;
		
	}
	
	public synchronized String getIdGenerate(String prefix) {
		String id = "";
		if(StringUtils.isBlank(prefix)) {
			return id;
		}
		IdDto idDto = getId(prefix);
		if(idDto == null) {
			return id;
		}
		String value = idDto.getValue();
		int newValue = 0;
		if(!StringUtils.isBlank(value)){
		 newValue = Integer.parseInt(value)+1; 
		}
		String str = String.valueOf(newValue);
		idDto.setValue(str);
		idGenerateDao.updateIdGenerate(idDto);
		return prefix+str;
	}
	
}

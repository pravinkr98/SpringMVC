package com.ps.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.ps.model.IExamResult;
import com.ps.model.OExamResult;

@Component
public class ExamResultProcessor implements ItemProcessor<IExamResult, OExamResult> {

	@Override
	public OExamResult process(IExamResult item) throws Exception {
		OExamResult oresult=null;
		if(item.getPercentage()>=90) {
			oresult=new OExamResult();
			/*oresult.setId(item.getId());
			oresult.setSemester(item.getSemester());
			oresult.setPercentage(item.getPercentage());*/
			BeanUtils.copyProperties(item, oresult, "dob");
			oresult.setDob(java.sql.Date.valueOf(item.getDob()));
			return oresult;
		}
		else
			return null;
		
	}

}

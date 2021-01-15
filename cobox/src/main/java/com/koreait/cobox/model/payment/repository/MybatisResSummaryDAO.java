package com.koreait.cobox.model.payment.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.cobox.exception.ResSummaryRegistException;
import com.koreait.cobox.model.domain.ResSummary;

@Repository
public class MybatisResSummaryDAO  implements ResSummaryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public void insert(ResSummary resSummary) throws ResSummaryRegistException{
		int result = sqlSessionTemplate.insert("Payment.insert", resSummary);
		if (result ==0) {
			throw new ResSummaryRegistException("결제정보 등록 실패");
		}
	}

}

package com.koreait.cobox.model.payment.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MaybatisPaymethodDAO implements PaymethodDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Paymethod.selectAll");
	}

	@Override
	public void registReservation() {
		// TODO Auto-generated method stub
		
	}

}

package com.koreait.cobox.model.reservation.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.cobox.exception.ReservationException;
import com.koreait.cobox.model.domain.Member;
import com.koreait.cobox.model.domain.Reservation;

@Repository
public class MybatisReservationDAO implements ReservationDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll(int member_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reservation select(int reservation_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void insert(Reservation reservation) throws ReservationException{
		int result=sqlSessionTemplate.insert("Reservation.insertById",reservation);
		if(result==0) {
			throw new ReservationException("예매에 실패 했습니다.");
		}
	}

	@Override
	public void update(Reservation reservation) {
		
	}

	@Override
	public void delete(Reservation reservation) {
		
	}

	@Override
	public void delete(Member member) {
		
	}

}
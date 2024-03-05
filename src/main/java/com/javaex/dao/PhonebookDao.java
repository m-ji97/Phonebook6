package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhonebookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//등록
	public int personInsert(PersonVo personVo) {
		System.out.println("PhonebookDao.personInsert()");
		
		return sqlSession.insert("phonebook.insert", personVo);
		
		//int count = sqlSession.insert("phonebook.insert", personVo); 동일
		//return count;
	}
	
	//리스트
	public List<PersonVo> personSelect(){
		System.out.println("PhonebookDao.personSelect()");
		
		List<PersonVo> personList = sqlSession.selectList("Phonebook.Select");
		System.out.println(personList);
		return personList;
	}
	
}

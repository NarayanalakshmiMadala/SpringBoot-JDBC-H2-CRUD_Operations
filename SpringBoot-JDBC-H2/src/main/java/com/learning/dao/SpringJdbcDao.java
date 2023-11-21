package com.learning.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.jdbc.CourceInfo;

@Repository
public class SpringJdbcDao 
{
	@Autowired
	private JdbcTemplate springJdbc;
	private static final String INSERT_QUERY="insert into course(id,cname,courceFee) values(?,?,?)";
	private static final String DELETE_QUERY = "delete from course where id=?";
	private static final String SELECT_QUERY=" select * from course where id= ? ";
	private static final String SELECT_ALL="select * from course";
	private static final String UPDATE_QUERY="update course set cname=?,courceFee=? where id=?";
	
		
	public int insert(CourceInfo cource)
	{
		return springJdbc.update(INSERT_QUERY,cource.getId(),cource.getCname(),cource.getCourceFee());
	}
	public int update(CourceInfo cource)
	{
		return springJdbc.update(UPDATE_QUERY,cource.getCname(),cource.getCourceFee(),cource.getId());
	}
	
	public int deleteById(int id)
	{
		return springJdbc.update(DELETE_QUERY,id);	
	}
	
	public List<CourceInfo> findById(long id)
	{
		List<CourceInfo> resultList=springJdbc.query(SELECT_QUERY, new BeanPropertyRowMapper<>(CourceInfo.class),id);
		return resultList;
	}
	
	public List<CourceInfo> findAll()
	{
		List<CourceInfo> resultAll=springJdbc.query(SELECT_ALL,new BeanPropertyRowMapper<>(CourceInfo.class));
		return resultAll;
	}

}

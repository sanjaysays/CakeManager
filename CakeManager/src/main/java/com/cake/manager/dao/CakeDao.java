package com.cake.manager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.cake.manager.dto.CakeDTO;

@Mapper
public interface CakeDao {

		@Results({
		  @Result(property = "id", column = "id"),
		  @Result(property = "cakeName", column = "cake_name"),
		  @Result(property = "cakeDescription", column = "cake_description"),
		  @Result(property = "cakePrice", column = "cake_price")
		  })
	 	@Select("select * from T_CAKES")
	    public List<CakeDTO> findAll();

		@Results({
			  @Result(property = "id", column = "id"),
			  @Result(property = "cakeName", column = "cake_name"),
			  @Result(property = "cakeDescription", column = "cake_description"),
			  @Result(property = "cakePrice", column = "cake_price")
			  })
	    @Select("SELECT * FROM T_CAKES WHERE UPPER(cake_name) = UPPER(#{cakeName})")
		public CakeDTO findByName(String cakeName);

	    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") 
	    @Insert("INSERT INTO T_CAKES(cake_name, cake_description,cake_price) " +
	        " VALUES (#{cakeName}, #{cakeDescription}, #{cakePrice})")
	    @SelectKey(statement="call identity()", keyProperty="id", before=true, resultType=int.class) 
	    public int insert(CakeDTO newCake);
	
}
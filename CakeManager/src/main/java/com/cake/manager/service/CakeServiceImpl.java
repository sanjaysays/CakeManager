package com.cake.manager.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cake.manager.dao.CakeDao;
import com.cake.manager.dto.CakeDTO;
import com.cake.manager.service.interfaces.CakeService;

@Service
public class CakeServiceImpl implements CakeService {
	
  @Autowired
	   CakeDao cakeDao;

@Override
public List<CakeDTO> findAll() {
	return cakeDao.findAll();
}


@Override
public CakeDTO findByName(String cakeName) {
	return cakeDao.findByName(cakeName);
}

@Override
public int insert(CakeDTO newCake) {
	return cakeDao.insert(newCake);
}

	
}

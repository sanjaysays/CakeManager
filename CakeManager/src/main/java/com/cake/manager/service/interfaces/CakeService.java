package com.cake.manager.service.interfaces;

import java.util.List;

import com.cake.manager.dto.CakeDTO;

public interface CakeService {

	public List<CakeDTO> findAll();
    
    public CakeDTO findByName(String cakeName);

    public int insert(CakeDTO newCake);
	
}

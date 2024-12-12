package com.sergio.fastservice.entity.services;

import java.util.List;

import com.sergio.fastservice.entity.models.Tables;

public interface ITableService {
	public Tables get(long id);
	public List<Tables> getAll();
	public void post(Tables table);
	public void put(Tables table, long id);
}

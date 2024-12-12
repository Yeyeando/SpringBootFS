package com.sergio.fastservice.entity.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergio.fastservice.entity.dao.ITablesDao;
import com.sergio.fastservice.entity.models.Tables;

@Service
public class TableServiceImpl implements ITableService{
	
	@Autowired
	private ITablesDao tableDao;
	
	@Override
	public Tables get(long id) {
		return tableDao.findById(id).get();
	}
	
	@Override
	public List<Tables>getAll() {
		return (List<Tables>) tableDao.findAll();
	}
	
	@Override
	public void post(Tables table) {
		tableDao.save(table);
	}
	
	@Override
	public void put(Tables table, long id) {
		tableDao.findById(id).ifPresent((x)->{
			table.setId_table(id);
			tableDao.save(table);
		});;
	}
	
}

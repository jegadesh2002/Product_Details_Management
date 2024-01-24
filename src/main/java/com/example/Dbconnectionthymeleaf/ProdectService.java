package com.example.Dbconnectionthymeleaf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProdectService {
	@Autowired
	private ProductRepository repo;
	public List<Product> listAll(){
		return repo.findAll();
	}
	
	public String save(Product product)
	{
		repo.save(product);
		return "redirect:/";
	}
	
	public Product get(long id)
	{
		return repo.findById(id).get();
	}
	
	public void delete(long id)
	{
		repo.deleteById(id);
	}
	
}

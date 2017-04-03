package br.com.casadocodigo.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.casadocodigo.loja.model.Product;

@Controller
public class ProductsController {

	/**
	 * Realiza o cadastro do produto
	 */
	@RequestMapping(value = "/produtos")
	public String save(Product product){
		return "products/ok";
	}
	
	/**
	 * Direciona para página de cadastro
	 */
	@RequestMapping(value = "/produtos/form")
	public String form(){
		return "products/form";
	}
	
}

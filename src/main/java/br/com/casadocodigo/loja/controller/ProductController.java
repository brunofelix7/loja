package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.model.BookType;
import br.com.casadocodigo.loja.model.Product;

@Controller
@Transactional
@RequestMapping(value = "/produtos")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(method = RequestMethod.POST)
	public String save(Product product, RedirectAttributes redirectAttributes){
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("message", "Produto cadastrado com sucesso!");
		return "redirect:produtos";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/form")
	public ModelAndView form(){
		ModelAndView mv = new ModelAndView("products/form");
		mv.addObject("types", BookType.values());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView mv = new ModelAndView("products/list");
		mv.addObject("products", productDAO.findAll());
		return mv;
	}
	
}

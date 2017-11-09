package br.com.casadocodigo.loja.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.casadocodigo.loja.dao.ProductDAO;
import br.com.casadocodigo.loja.model.BookType;
import br.com.casadocodigo.loja.model.Product;
import br.com.casadocodigo.loja.util.FileSaver;
import br.com.casadocodigo.loja.validation.ProductValidation;

@Controller
@Transactional
@RequestMapping(value = "/produtos")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private FileSaver fileSaver;
	
	//	A annotation @InitBinder indica que esse método deve ser chamado sempre que um request cair no controller em questão
	@InitBinder
	protected void initBinder(WebDataBinder dataBinder){
		dataBinder.setValidator(new ProductValidation());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(MultipartFile summary, @Valid Product product, BindingResult result, RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return form(product);
		}
		String webPath = fileSaver.writeS3("uploaded-summary", summary);
		product.setSummaryPath(webPath);
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("message", "Produto cadastrado com sucesso!");
		return new  ModelAndView("redirect:produtos");
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/form")
	public ModelAndView form(Product product){
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

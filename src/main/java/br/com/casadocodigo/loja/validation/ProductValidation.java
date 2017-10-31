package br.com.casadocodigo.loja.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import br.com.casadocodigo.loja.model.Product;

public class ProductValidation implements Validator{

	@Override
	public boolean supports(Class<?> target) {
		return Product.class.isAssignableFrom(target);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "field.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "field.required");
		Product product = (Product) target;
		if(product.getPages() != null){
			if(product.getPages() <= 0){
				errors.rejectValue("pages", "field.required");
			}
		}else{
			errors.rejectValue("pages", "field.required");
		}
	}
}

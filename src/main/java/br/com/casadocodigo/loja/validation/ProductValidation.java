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
		ValidationUtils.rejectIfEmpty(errors, "title", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "field.required");
		Product product = (Product) target;
		if(product.getPages() <= 0){
			errors.rejectValue("pages", "field.required");
		}
	}
}

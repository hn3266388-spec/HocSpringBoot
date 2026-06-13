package Study.spring.boot.CauTrucChuan.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CccdValidator implements ConstraintValidator<Cccd,String> {
          @Override
          public boolean isValid(String value, ConstraintValidatorContext ct) {
        	  if(value ==null || value.isBlank()) {
        		  return true;
        	  }
        	 return value.matches("[0-9]{12}$");
        	  
          }
}

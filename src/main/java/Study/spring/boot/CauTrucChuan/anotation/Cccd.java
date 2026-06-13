package Study.spring.boot.CauTrucChuan.anotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CccdValidator.class)
public @interface Cccd {
	String message() default "Số căn cước công dân gồm 12 số";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
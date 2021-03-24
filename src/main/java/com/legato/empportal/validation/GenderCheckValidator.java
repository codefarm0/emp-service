package com.legato.empportal.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.legato.empportal.entity.Gender;

public class GenderCheckValidator implements ConstraintValidator<GenderCheck, String> {

	

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		System.out.println("value"+value);

		Boolean isGenderExists = Gender.contains(value);

		if (isGenderExists) {
			System.out.println("isGenderExists"+isGenderExists);
			return true;
		}

		else {
			System.out.println("isGenderExists"+isGenderExists);
			return false;
		}
	}

}

package com.japetech.games.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank(message = "Campo não deve estar em branco")
public @interface StringGames {
    String message() default "Campo deve ter no máximo 50 caracteres e não deve estar em branco.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

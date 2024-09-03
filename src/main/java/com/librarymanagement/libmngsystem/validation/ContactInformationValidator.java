package com.librarymanagement.libmngsystem.validation;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
//import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
//import org.apache.commons.validator.routines.EmailValidator;


import java.util.Map;
import java.util.regex.Pattern;

@Component
@Slf4j
public class ContactInformationValidator {
    public void validateContactInformation(Map<String, String> contactInfo) {
        String phone = contactInfo.get("phone");
        if (phone == null || !isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone number format.");
        }

        String email = contactInfo.get("email");
        if (email == null || !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address format.");
        }

        String address = contactInfo.get("address");
        if (address == null || StringUtils.isBlank(address)) {
            log.error("...");
            throw new IllegalArgumentException("Address must not be empty");
        }
    }

    private boolean isValidPhone(String phone) {
        String phoneRegex = "^\\\\+\\\\d{10,15}$";
        Pattern phonePattern = Pattern.compile(phoneRegex);
        return phone != null && phonePattern.matcher(phone).matches();
    }

    private boolean isValidEmail(String email) {
//        EmailValidator emailValidator = EmailValidator.getInstance();
//        boolean nn = emailValidator.isValid(email);

        String emailRegex = "^(?=.{1,256})(?=.{1,64}@)[^@\\s]+@[^@\\s]+\\.[^@\\s]+$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        return email != null && emailPattern.matcher(email).matches();
    }
}
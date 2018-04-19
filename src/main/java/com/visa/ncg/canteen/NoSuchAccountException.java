package com.visa.ncg.canteen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No account with that ID was found.")
public class NoSuchAccountException extends RuntimeException {

}

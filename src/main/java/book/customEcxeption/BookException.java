package book.customEcxeption;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookException {

    @ExceptionHandler(Exception.class)
    public String exceptionHandle(Exception e){
        e.printStackTrace();
        return "redirect:/";
    }
}

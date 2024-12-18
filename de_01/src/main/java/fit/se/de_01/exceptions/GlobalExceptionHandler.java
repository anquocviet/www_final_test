package fit.se.de_01.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
   final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());

   @ExceptionHandler(AppException.class)
   public ModelAndView handleAppException(AppException e) {
      logger.info(e.toString());
      ModelAndView mav = new ModelAndView("error/error");
      mav.addObject("exception", e.getMessage());
      return mav;
   }


   @ExceptionHandler(Exception.class)
   public ModelAndView handleException(Exception e) {
      logger.info(e.toString());
      ModelAndView mav = new ModelAndView("error/error");
      mav.addObject("exception", e.getMessage());
      return mav;
   }
}

package fit.se.de_01.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description
 * @author: vie
 * @date: 18/12/24
 */
@Getter
@AllArgsConstructor
public class AppException extends RuntimeException {
   private String message;
   private int status;
}

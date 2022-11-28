package uol.compass.politics.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {
    private Integer status;
    private String message;
    private Throwable throwable;
}

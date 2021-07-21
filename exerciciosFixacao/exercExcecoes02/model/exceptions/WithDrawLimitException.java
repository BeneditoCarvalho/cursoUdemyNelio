package cursoUdemyNelio.exerciciosFixacao.exercExcecoes02.model.exceptions;

import java.io.Serial;

public class WithDrawLimitException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;


    public WithDrawLimitException(String msg) {
        super(msg);
    }
}

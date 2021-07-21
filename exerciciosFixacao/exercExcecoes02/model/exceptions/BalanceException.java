package cursoUdemyNelio.exerciciosFixacao.exercExcecoes02.model.exceptions;

import java.io.Serial;

public class BalanceException extends RuntimeException {


    @Serial
    private static final long serialVersionUID = 1L;

    public BalanceException(String msg) {
        super(msg);
    }

}

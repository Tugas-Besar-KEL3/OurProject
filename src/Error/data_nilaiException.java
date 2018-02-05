/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Error;

/**
 *
 * @author MY PC
 */
public class data_nilaiException extends Exception {

    /**
     * Creates a new instance of <code>data_nilaiException</code> without detail
     * message.
     */
    public data_nilaiException() {
    }

    /**
     * Constructs an instance of <code>data_nilaiException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public data_nilaiException(String msg) {
        super(msg);
    }
}

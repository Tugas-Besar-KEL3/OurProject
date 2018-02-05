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
public class data_siswaException extends Exception {

    /**
     * Creates a new instance of <code>data_siswaException</code> without detail
     * message.
     */
    public data_siswaException() {
    }

    /**
     * Constructs an instance of <code>data_siswaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public data_siswaException(String msg) {
        super(msg);
    }
}

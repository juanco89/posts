
package com.juanco.posts.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Clase util que entrega el HexString del MD5 de la cadena especificada.
 * 
 * @author Juan C. Orozco <juanco89@gmail.com>
 */
public class MD5 {

    public static String toHexString(String input) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes(), 0, input.length());
            byte[] hash = md.digest();
            // System.out.println(new BigInteger(hash).toString(16));
            
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(Integer.toHexString((int) (b & 0xff)));
            }
            
            return sb.toString();
        }catch (NoSuchAlgorithmException e) {}
        
        return null;
    }
}

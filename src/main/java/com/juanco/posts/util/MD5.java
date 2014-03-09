
package com.juanco.posts.util;

import java.io.UnsupportedEncodingException;
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
            md.update(input.getBytes("iso-8859-1"), 0, input.length());
            byte[] hash = md.digest();
            
            return convertToHex(hash);
        }catch (NoSuchAlgorithmException | UnsupportedEncodingException  e) {}
        
        return null;
    }

    /**
     * Convierte de hash a una cadena Hexadecimal.
     */
    private static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                if ((0 <= halfbyte) && (halfbyte <= 9)) {
                    buf.append((char) ('0' + halfbyte));
                } else {
                    buf.append((char) ('a' + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }
}

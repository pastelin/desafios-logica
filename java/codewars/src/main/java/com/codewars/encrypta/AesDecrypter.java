package com.codewars.encrypta;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AesDecrypter {

    // --- PARÁMETROS CRÍTICOS ---
    // Coloca la clave que encontraste aquí, sin importar su longitud inicial.
    private static final String SECRET_KEY = "================================="; // <-- REEMPLAZA ESTO CON TU CLAVE REAL

    // Probaremos con el modo ECB que no necesita IV.
    private static final String ALGORITHM = "AES/ECB/NoPadding";

    /**
     * NUEVO: Esta función toma la clave original y la ajusta a 32 bytes (256 bits),
     * replicando el comportamiento del código VB6.
     */
    private static SecretKeySpec createKeySpec(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        // Creamos un nuevo array de 32 bytes, rellenado con ceros.
        byte[] truncatedKey = new byte[32];
        // Copiamos tantos bytes como sea posible de la clave original (hasta un máximo de 32).
        System.arraycopy(keyBytes, 0, truncatedKey, 0, Math.min(keyBytes.length, 32));
        return new SecretKeySpec(truncatedKey, "AES");
    }

    public static String decrypt(String encryptedHex) {
        try {
            // 1. Preparar la Clave Secreta (usando nuestra nueva función)
            SecretKeySpec skeySpec = createKeySpec(SECRET_KEY);

            // 2. Inicializar el Cipher en modo DESENCRIPTAR
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);

            // 3. Convertir la cadena Hex a un array de bytes
            byte[] encryptedBytes = hexStringToByteArray(encryptedHex);

            // 4. Realizar la desencriptación
            byte[] original = cipher.doFinal(encryptedBytes);

            // 5. Convertir los bytes desencriptados a una cadena de texto
            return new String(original);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public static void main(String[] args) {
        String encryptedValue = "02233724EB90B0220B14AE42E3140812A041E0112F198342E2132D378124E014";
        String knownPlaintext = "MB13787";

        System.out.println("Intentando desencriptar el valor...");
        System.out.println("Valor Encriptado: " + encryptedValue);

        String decryptedValue = decrypt(encryptedValue);

        if (decryptedValue != null) {
            System.out.println("Valor Desencriptado: " + decryptedValue);
            // Limpiamos los caracteres nulos que puedan venir del padding
            System.out.println("¿Coincide con el valor en claro conocido? " + decryptedValue.trim().equals(knownPlaintext));
        } else {
            System.out.println("La desencriptación falló. Revisa la clave, IV y el algoritmo.");
        }
    }
}

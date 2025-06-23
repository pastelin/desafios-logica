public class Main {

    static final String getCode(String pCadena) {
        /*  6 */
        int i = 0;
        /*  7 */
        String strBuscado = "";
        /*  8 */
        int val = 0;
        /*  9 */
        StringBuffer strValor = new StringBuffer();
        /* 10 */
        StringBuffer paso = new StringBuffer(pCadena.toLowerCase());
        /*    */
        /* 12 */
        for (i = paso.length() - 1; i >= 0; i -= 3) {
            /* 13 */
            strBuscado = paso.substring(i - 2);
            /* 14 */
            paso.delete(i - 2, i + 1);
            /* 15 */
            val = Integer.parseInt(strBuscado, 16);
            /* 16 */
            strValor.append((char) (val - 51));
            /*    */
        }
        /* 18 */
        return strValor.toString();
        /*    */
    }

    public static String encrypt(String palabra) {
        StringBuilder resultado = new StringBuilder();
        for (char c : palabra.toCharArray()) {
            int val = c + 51; // Sumar 51 al valor del carácter
            String hex = Integer.toHexString(val).toUpperCase(); // Convertir a hexadecimal
            while (hex.length() < 3) {
                hex = "0" + hex; // Asegurar que tenga al menos 3 caracteres
            }
            resultado.append(hex);
        }
        return resultado.toString();
    }

    public static void main(String[] args) {

        System.out.println(encrypt("exodo"));
        System.out.println(getCode(encrypt("exodo")));
        System.out.println(getCode("0A20970A20AB098"));

    }

}

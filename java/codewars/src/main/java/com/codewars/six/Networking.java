package com.codewars.six;

public class Networking {


    /**
     * Calculates the number of usable host addresses in a subnet based on the given subnet mask.
     *
     * @param subnetMask The subnet mask in dotted decimal notation (e.g., "255.255.255.0").
     * @return The number of usable host addresses in the subnet.
     */
    public static long getHostCountInSubnet(String subnetMask) {
        // Split the subnet mask into its four segments
        String[] subnetMaskSegments = subnetMask.split("\\.");
        long totalHostAddresses = 1;

        int hostBitCount = 0;

        for (String segment : subnetMaskSegments) {
            int segmentValue = Integer.parseInt(segment);
            // Check if the segment is a valid subnet mask segment
            if (segmentValue < 255) {
                if (segmentValue == 0) {
                    hostBitCount += 8; // All bits are host bits
                } else {
                    // Count the number of host bits in the segment
                    while (segmentValue > 0) {
                        // El operador & realiza una operación AND a nivel de bits entre dos números. Compara cada bit de
                        // los operandos y devuelve un 1 solo si ambos bits son 1. En el código:
                        System.out.println((segmentValue & 1));
                        if ((segmentValue & 1) == 0) { // Check if the least significant bit is 0 (host bit)
                            hostBitCount++;
                        }
                        /*
                        * Propósito: Verificar si el bit menos significativo (el bit más a la derecha) de segmentValue es 0.
                        Cómo funciona:
                        segmentValue & 1 toma el valor binario de segmentValue y realiza una operación AND con 1 (que en binario es 00000001).
                        Esto aísla el bit menos significativo de segmentValue. Si el resultado es 0, significa que el bit menos significativo es 0.
                        Ejemplo:
                        Si segmentValue = 6 (binario: 00000110), entonces 6 & 1 = 0 (el bit menos significativo es 0).
                        Si segmentValue = 7 (binario: 00000111), entonces 7 & 1 = 1 (el bit menos significativo es 1).
                        *
                        * */


                        // El operador >> desplaza los bits de un número hacia la derecha. Cada desplazamiento elimina el bit
                        // menos significativo y agrega un 0 en el bit más significativo (para números positivos). En el código:
                        segmentValue >>= 1; // Shift right to check the next bit

                        /*
                        * Propósito: Desplazar los bits de segmentValue hacia la derecha para procesar el siguiente bit.
                        Cómo funciona:
                        segmentValue >>= 1 es equivalente a segmentValue = segmentValue / 2 (para números enteros positivos), pero es más eficiente porque opera directamente a nivel de bits.
                        Cada vez que se ejecuta, el bit menos significativo se elimina, y el siguiente bit se convierte en el nuevo bit menos significativo.
                        Ejemplo:
                        Si segmentValue = 6 (binario: 00000110), después de segmentValue >>= 1, el valor será 3 (binario: 00000011).
                        Si segmentValue = 7 (binario: 00000111), después de segmentValue >>= 1, el valor será 3 (binario: 00000011).
                        *
                        *
                        * */
                    }
                }
            }
        }

        /*
        * 1L:
        Es un literal de tipo long con el valor 1. Se utiliza para asegurarse de que el cálculo se realice con precisión
        * en números grandes, ya que el resultado puede exceder el rango de un entero (int).

        * << (Desplazamiento a la izquierda):
        Este operador desplaza los bits de 1L hacia la izquierda un número de posiciones igual a hostBitCount.
        Desplazar un bit hacia la izquierda es equivalente a multiplicar por 2 elevado al número de posiciones desplazadas.
        Por ejemplo:
        Si hostBitCount = 3, entonces 1L << 3 es igual a 2^3 = 8.

        * (1L << hostBitCount):
        Calcula 2^hostBitCount. Esto representa el número total de direcciones posibles en la subred, incluyendo las direcciones reservadas (red y broadcast).

        * - 2:
        Se resta 2 para excluir las direcciones reservadas:
        Dirección de red: Identifica la subred.
        Dirección de broadcast: Se utiliza para enviar mensajes a todos los dispositivos en la subred.
        *
        * Ejemplo práctico:
        Supongamos que hostBitCount = 8:
        1L << 8 calcula 2^8 = 256 (total de direcciones posibles).
        256 - 2 da como resultado 254, que son las direcciones de host utilizables.
        * */
        totalHostAddresses = (1L << hostBitCount) - 2;

        // Return 1 if no host bits are available (e.g., 255.255.255.255)
        return hostBitCount == 0 ? 1 : Math.max(totalHostAddresses, 2);
    }


    public static void main(String[] args) {
        getHostCountInSubnet("255.255.255.0");
        System.out.println(getHostCountInSubnet("255.255.255.0"));
        System.out.println(getHostCountInSubnet("255.255.255.254"));
        getHostCountInSubnet("255.255.0.0");
        getHostCountInSubnet("255.0.0.0");
    }


}

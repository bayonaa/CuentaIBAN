package es.iesmz.tests;

import java.math.BigInteger;

public class Compte {
    private String numeroCuenta;
    private String nombreTitular;

    public Compte() {

    }

    public boolean compruebaIBAN(String iban) {
        if (iban.length() != 24) {
            System.err.println("ERROR. La longitud del IBAN es incorrecta");
            return false;
        }

        String ibanModif = iban.substring(4) + iban.substring(0, 4);

        StringBuilder ibanNum = new StringBuilder();
        for (int i = 0; i < ibanModif.length(); i++) {
            char c = ibanModif.charAt(i);
            if (Character.isLetter(c)) {
                ibanNum.append(Character.getNumericValue(c));
            } else {
                ibanNum.append(c);
            }
        }

        BigInteger numIBAN = new BigInteger(ibanNum.toString());

        return numIBAN.mod(new BigInteger("97")).intValue() == 1;
    }

    public String generaIBAN(String entidad, String oficina, String dc, String cuenta) {
        if (!validarEntradas(entidad, oficina, dc, cuenta)) {
            return null;
        }

        String iban = entidad + oficina + dc + cuenta + "142800";

        BigInteger b1 = new BigInteger(iban);
        BigInteger b2 = new BigInteger("97");
        BigInteger result = b1.mod(b2);
        BigInteger resta = result.subtract(new BigInteger("98")).abs();
        String resultadoCadena = resta.toString();
        if (resultadoCadena.length() == 1) {
            resultadoCadena = "0" + resultadoCadena;
        }

        String ibanCompleto = "ES" + resultadoCadena + entidad + oficina + dc + cuenta;

        return ibanCompleto;
    }

    private boolean validarEntradas(String entidad, String oficina, String dc, String cuenta) {
        if (!esNumero(entidad) || !esNumero(oficina) || !esNumero(dc) || !esNumero(cuenta)) {
            return false;
        } else {
            return entidad.length() == 4 && oficina.length() == 4 && dc.length() == 2 && cuenta.length() == 10;
        }
    }

    private boolean esNumero(String str) {
        return str.matches("\\d+");
    }
}
package br.com.goldbeg.conversormoedas;

public class Moeda {
    private String baseCode;
    private String targetCode;
    private double conversionRate;

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public double getConversionRate() {
        return conversionRate;
    }
}
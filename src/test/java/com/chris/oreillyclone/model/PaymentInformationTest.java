package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PaymentInformationTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentInformation#setCardNumber(String)}
     *   <li>{@link PaymentInformation#setCardholderName(String)}
     *   <li>{@link PaymentInformation#setCvv(String)}
     *   <li>{@link PaymentInformation#setExpirationDate(LocalDate)}
     *   <li>{@link PaymentInformation#getCardNumber()}
     *   <li>{@link PaymentInformation#getCardholderName()}
     *   <li>{@link PaymentInformation#getCvv()}
     *   <li>{@link PaymentInformation#getExpirationDate()}
     * </ul>
     */
    @Test
    void testSetCardNumber() {
        PaymentInformation paymentInformation = new PaymentInformation();
        paymentInformation.setCardNumber("42");
        paymentInformation.setCardholderName("Cardholder Name");
        paymentInformation.setCvv("Cvv");
        LocalDate expirationDate = LocalDate.of(1970, 1, 1);
        paymentInformation.setExpirationDate(expirationDate);
        String actualCardNumber = paymentInformation.getCardNumber();
        String actualCardholderName = paymentInformation.getCardholderName();
        String actualCvv = paymentInformation.getCvv();
        assertEquals("42", actualCardNumber);
        assertEquals("Cardholder Name", actualCardholderName);
        assertEquals("Cvv", actualCvv);
        assertSame(expirationDate, paymentInformation.getExpirationDate());
    }
}


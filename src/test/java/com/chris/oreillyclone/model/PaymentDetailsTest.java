package com.chris.oreillyclone.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

class PaymentDetailsTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentDetails#PaymentDetails()}
     *   <li>{@link PaymentDetails#setAmountPaid(double)}
     *   <li>{@link PaymentDetails#setPaymentDate(LocalDateTime)}
     *   <li>{@link PaymentDetails#setPaymentId(String)}
     *   <li>{@link PaymentDetails#setPaymentMethod(String)}
     *   <li>{@link PaymentDetails#setStatus(String)}
     *   <li>{@link PaymentDetails#setTransactionId(String)}
     *   <li>{@link PaymentDetails#getAmountPaid()}
     *   <li>{@link PaymentDetails#getPaymentDate()}
     *   <li>{@link PaymentDetails#getPaymentId()}
     *   <li>{@link PaymentDetails#getPaymentMethod()}
     *   <li>{@link PaymentDetails#getStatus()}
     *   <li>{@link PaymentDetails#getTransactionId()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PaymentDetails actualPaymentDetails = new PaymentDetails();
        actualPaymentDetails.setAmountPaid(10.0d);
        LocalDateTime paymentDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPaymentDetails.setPaymentDate(paymentDate);
        actualPaymentDetails.setPaymentId("42");
        actualPaymentDetails.setPaymentMethod("Payment Method");
        actualPaymentDetails.setStatus("Status");
        actualPaymentDetails.setTransactionId("42");
        double actualAmountPaid = actualPaymentDetails.getAmountPaid();
        LocalDateTime actualPaymentDate = actualPaymentDetails.getPaymentDate();
        String actualPaymentId = actualPaymentDetails.getPaymentId();
        String actualPaymentMethod = actualPaymentDetails.getPaymentMethod();
        String actualStatus = actualPaymentDetails.getStatus();
        assertEquals(10.0d, actualAmountPaid);
        assertSame(paymentDate, actualPaymentDate);
        assertEquals("42", actualPaymentId);
        assertEquals("Payment Method", actualPaymentMethod);
        assertEquals("Status", actualStatus);
        assertEquals("42", actualPaymentDetails.getTransactionId());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link PaymentDetails#PaymentDetails(String, String, String, String, LocalDateTime, double)}
     *   <li>{@link PaymentDetails#setAmountPaid(double)}
     *   <li>{@link PaymentDetails#setPaymentDate(LocalDateTime)}
     *   <li>{@link PaymentDetails#setPaymentId(String)}
     *   <li>{@link PaymentDetails#setPaymentMethod(String)}
     *   <li>{@link PaymentDetails#setStatus(String)}
     *   <li>{@link PaymentDetails#setTransactionId(String)}
     *   <li>{@link PaymentDetails#getAmountPaid()}
     *   <li>{@link PaymentDetails#getPaymentDate()}
     *   <li>{@link PaymentDetails#getPaymentId()}
     *   <li>{@link PaymentDetails#getPaymentMethod()}
     *   <li>{@link PaymentDetails#getStatus()}
     *   <li>{@link PaymentDetails#getTransactionId()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        PaymentDetails actualPaymentDetails = new PaymentDetails("Payment Method", "Status", "42", "42",
                LocalDate.of(1970, 1, 1).atStartOfDay(), 10.0d);
        actualPaymentDetails.setAmountPaid(10.0d);
        LocalDateTime paymentDate = LocalDate.of(1970, 1, 1).atStartOfDay();
        actualPaymentDetails.setPaymentDate(paymentDate);
        actualPaymentDetails.setPaymentId("42");
        actualPaymentDetails.setPaymentMethod("Payment Method");
        actualPaymentDetails.setStatus("Status");
        actualPaymentDetails.setTransactionId("42");
        double actualAmountPaid = actualPaymentDetails.getAmountPaid();
        LocalDateTime actualPaymentDate = actualPaymentDetails.getPaymentDate();
        String actualPaymentId = actualPaymentDetails.getPaymentId();
        String actualPaymentMethod = actualPaymentDetails.getPaymentMethod();
        String actualStatus = actualPaymentDetails.getStatus();
        assertEquals(10.0d, actualAmountPaid);
        assertSame(paymentDate, actualPaymentDate);
        assertEquals("42", actualPaymentId);
        assertEquals("Payment Method", actualPaymentMethod);
        assertEquals("Status", actualStatus);
        assertEquals("42", actualPaymentDetails.getTransactionId());
    }
}


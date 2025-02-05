package com.jhcs.mockito.testDoubles.dummy;

public class DummyEmailService implements  EmailService{
    @Override
    public void sendEmail(String message) {
        throw new AssertionError("Metodo não implementado");
    }
}

package com.jhcs.displayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("Demonstração da anotação Display Name")
public class DisplayNameDemo {
    @Test
    @DisplayName("@DisplayName demonstração de teste")
    public void displayNameDemoTest() {
        assertEquals(3,2+1);

    }
    @Test
    @DisplayName("@DisplayName demonstração com espaços")
    public void displayNameDemoWithSpaces() {
        assertEquals(3, 2 + 1);
    }

    @Test
    @DisplayName("@DisplayName demonstração com ╯°□°）╯ @!~ characteres especiais")
    public void displayNameDemoWithSpecialCharacters() {
        assertEquals(3, 2 + 1);
    }

    @Test
    @DisplayName("@DisplayName demonstração com emojis - 😱")
    public void displayNameDemoWithEmojis() {
        assertEquals(3, 2 + 1);
    }
}

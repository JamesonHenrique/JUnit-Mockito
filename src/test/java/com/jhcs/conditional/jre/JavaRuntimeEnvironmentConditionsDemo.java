package com.jhcs.conditional.jre;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;


public class JavaRuntimeEnvironmentConditionsDemo {

    @Test
    @EnabledOnJre(JRE.JAVA_21)
    public void enableOnJava21() {
        System.out.println("Habilitado no JRE 21");
    }
    @Test
    @DisabledOnJre(JRE.JAVA_21)
    public void disableOnJava21() {
        System.out.println("Desabilitado no JRE 21");
    }
}

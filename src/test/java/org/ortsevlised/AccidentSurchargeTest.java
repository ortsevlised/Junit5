package org.ortsevlised;

import jline.internal.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
class AccidentSurchargeTest {
    HashMap<Integer, ToPay> accidentSurcharge;

    @BeforeAll
    static void setup() {
        Log.info(">>> Started tests for: "+AccidentSurcharge.class);
    }

    @AfterAll
    static void tearDown() {
        Log.info(">>> Finished tests for: "+AccidentSurcharge.class);
    }

    @DisplayName("Testing accident surcharge returns the correct amount")
    @ParameterizedTest
    @CsvSource({
            "0,343",
            "1,1000",
            "2,-5",
            "3,2323",
            "4,99999999",
            "5,4440"
    })
    public void accidentSurchargeTest(int key, int currentPrice) {
        accidentSurcharge = AccidentSurcharge.getAccidentSurcharge(currentPrice);
        assertEquals(accidentSurcharge.get(key).getAmount(), ExtraPerAccident.values()[key].getExtraToPay() + currentPrice);
    }

    @Test
    @DisplayName("Testing NullPointerException is thrown when trying to access a field of null key")
    public void accidentSurchargeThrowsNullPointerException() {
        accidentSurcharge = AccidentSurcharge.getAccidentSurcharge(new Random().nextInt());
        assertThrows(NullPointerException.class, () -> accidentSurcharge.get(accidentSurcharge.size()).getAmount());
    }
}
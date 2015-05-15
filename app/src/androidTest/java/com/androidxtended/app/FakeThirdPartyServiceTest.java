package com.androidxtended.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class FakeThirdPartyServiceTest {

    FakeThirdPartyService fakeThirdPartyService = new FakeThirdPartyService();

    @Test
    public void shouldBuildProperlyTheOpinion() {
        // given
        String userName = "Pepe";
        String opinion = "de lujo";

        // when
        String actualMessage = fakeThirdPartyService.buildOpinion(userName, opinion);

        // then
        assertEquals("Tu nombre es Pepe y opinas que #AndroidXtended es de lujo", actualMessage);
    }

    @Test
    public void shouldNoName() {
        // given
        String userName = "";
        String opinion = "de lujo";

        // when
        String actualMessage = fakeThirdPartyService.buildOpinion(userName, opinion);

        // then
        assertEquals("No tienes nombre, pero opinas que #AndroidXtended es de lujo", actualMessage);
    }

    @Test
    public void shouldNoOpinion() {
        // given
        String userName = "Pepe";
        String opinion = "";

        // when
        String actualMessage = fakeThirdPartyService.buildOpinion(userName, opinion);

        // then
        assertEquals("Tu nombre es Pepe, pero no opinas", actualMessage);
    }

    @Test
    public void shouldNothing() {
        // given
        String userName = "";
        String opinion = "";

        // when
        String actualMessage = fakeThirdPartyService.buildOpinion(userName, opinion);

        // then
        assertEquals("Ni tienes nombre ni opinas", actualMessage);
    }
}
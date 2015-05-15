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
}
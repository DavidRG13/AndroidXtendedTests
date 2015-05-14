package com.androidxtended.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class FakeThirdPartyServiceTest {

    FakeThirdPartyService fakeThirdPartyService = new FakeThirdPartyService();

    @Test
    public void shouldBuildProperlyTheOpinion() throws Exception {
        // given
        String userName = "Pepe";
        String opinion = "de lujo";

        // when
        String actualMessage = fakeThirdPartyService.buildOpinion(userName, opinion);

        // then
        assertEquals("Pepe de lujo en #AndroidXtended", actualMessage);
    }
}
package com.androidxtended.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FakeThirdPartyServiceTest {

    @Test
    public void shouldReturnEmptyNameAndOpinionWhenNoNameNeitherOpinion() {
        String opinion = "";
        String name = "";
        FakeThirdPartyService fakeThirdPartyService = new FakeThirdPartyService();

        String result = fakeThirdPartyService.buildOpinion(name, opinion);

        assertEquals("Ni tienes nombre ni opinas", result);
    }
}
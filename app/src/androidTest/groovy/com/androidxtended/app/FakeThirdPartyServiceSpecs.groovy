package com.androidxtended.app

import spock.lang.Specification

class FakeThirdPartyServiceSpecs extends Specification {

    def 'should return empty name and opinion when no name neither opinion'() {
        given:
        String emptyOpinion = ""
        String emptyName = ""
        FakeThirdPartyService fakeThirdPartyService = new FakeThirdPartyService()

        expect:
        "Ni tienes nombre ni opinas" == fakeThirdPartyService.buildOpinion(emptyName, emptyOpinion)
    }
}

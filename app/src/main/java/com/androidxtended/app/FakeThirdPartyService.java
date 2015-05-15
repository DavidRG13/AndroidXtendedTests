package com.androidxtended.app;

public class FakeThirdPartyService {

    public String buildOpinion(final String userName, final String opinion) {
        String opinionFromServer = getOpinionFromServer();
        return String.format(opinionFromServer, userName, opinion);
    }

    private String getOpinionFromServer() {
        return "Tu nombre es %s y opinas que #AndroidXtended es %s";
    }
}

package com.androidxtended.app;

public class FakeThirdPartyService {

    public String buildOpinion(final String userName, final String opinion) {

        if (opinion.isEmpty() && userName.isEmpty()) {
            return "Ni tienes nombre ni opinas";
        } else if (opinion.isEmpty()) {
            return String.format("Tu nombre es %s, pero no opinas", userName);
        } else if (userName.isEmpty()) {
            return String.format("No tienes nombre, pero opinas que #AndroidXtended es %s", opinion);
        } else {
            return String.format("Tu nombre es %s y opinas que #AndroidXtended es %s", userName, opinion);
        }
    }
}

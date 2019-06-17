package model.linguistic_variables;

import lombok.Getter;
import model.membership_functions.MembershipFunction;

import java.util.List;
import java.util.Map;

public class LinguisticVariable {
    @Getter
    protected String name;
    @Getter
    protected List<String> labels;
    @Getter
    protected String column;
    @Getter
    protected Map<String, MembershipFunction> membershipFunctions;

    public MembershipFunction getMembershipFunctionForLabel(String label) {
        return membershipFunctions.get(label);
    }

    public void setMembershipFunction(String label, MembershipFunction membershipFunction) {
        membershipFunctions.replace(label, membershipFunction);
    }
}

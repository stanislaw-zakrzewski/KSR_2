package sentence_building_blocks.membership_functions;

import model.membership_functions.MembershipFunction;

public class SClassMembershipFunction implements MembershipFunction {
    private float begging;
    private float end;

    public SClassMembershipFunction(float begging, float end) {
        this.begging = begging;
        this.end = end;
    }

    @Override
    public float calculateMembership(float value) {
        float b = ((begging + end) / 2);

        if (value <= begging) return 0;
        else if (begging < value && value <= b) return (float) (2 * Math.pow(((value - begging) / (end - begging)), 2));
        else if (b < value && value <= end) return (float) (1 - (2 * Math.pow(((value - end) / (end - begging)), 2)));
        else return 1;
    }

    @Override
    public float getSupport(float beggingValue, float endValue) {
        float b;
        if (beggingValue > begging) b = beggingValue;
        else b = begging;
        return endValue - b;
    }

    @Override
    public float getIntegralValue(float start, float stop) {
        //integrate 2((x-a)/(b-a))^2 from a to (a-b)/2
        float integral = 0;

        float middle = (end - begging)/2;

        if(start <= begging) {
            if(stop <= begging) {
                //start stop
                integral += 0;
            } else {
                //start e
                integral += 0;
            }
        }
        if(start <= middle) {
            if(start < begging) {
                if(stop  <= middle) {
                    //b stop
                } else {
                    //b middle
                }
            } else {
                if(stop  <= middle) {
                    //start stop
                } else {
                    //start middle
                }
            }
        }

        if(start <= middle) {
            if(start < begging) {
                if(stop  <= middle) {
                    //b stop
                } else {
                    //b middle
                }
            } else {
                if(stop  <= middle) {
                    //start stop
                } else {
                    //start middle
                }
            }
        }


        if(stop > end) {
            if(begging > end) {
                //bv ev
            } else {
                //e ev
            }
        }




        return 0;//TODO no nie ma

    }
}

package com.csa.util;

import com.csa.entity.Innings;
import com.csa.visualization.*;

/**
 * Created by User on 7/12/2016.
 */
public class ResultsFactory extends InningByInningsResults {

    int segment=0;

    public ResultsFactory(Innings innings) {

        this.segment = innings.getSegment();
    }

    public InningByInningsResults getFactoryClass() {

        switch (segment) {

            case 0: {
                return new CompleteResults();
            }
            case 1: {
                return new PPResults();
            }
            case 2: {
                return new MiddleResults();
            }
            case 3: {
                return new DeathResults();
            }
            default:{
                return new CompleteResults();
            }
        }
    }


}

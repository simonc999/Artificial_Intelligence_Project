package org.yawlfoundation.yawl.resourcing.codelets;

import java.util.List;

import org.jdom2.Element;
import org.yawlfoundation.yawl.elements.data.YParameter;

public class CalculateBMI extends AbstractCodelet {

    public CalculateBMI() {
        super();
        setDescription("This codelet returns a bmi value,<br>"
                + "following the expression weight/(height^2).<br>"
                + "Required parameters:<br>"
                + "Input: weight, height (double)<br>"
                + "Output: bmi (double)");
    }

    @Override
    public Element execute(Element inData, List<YParameter> inParams,
            List<YParameter> outParams) throws CodeletExecutionException {

        setInputs(inData, inParams, outParams);
        
        double peso;
        double altezza;
        try {
            altezza = Double.parseDouble((String) getParameterValue("altezza"));
            peso = Double.parseDouble((String) getParameterValue("peso"));

        } catch (ClassCastException cce) {
            throw new CodeletExecutionException("Exception casting input"
                    + " values to double types.");
        }
        setParameterValue("bmi", String.valueOf(peso/(altezza*altezza)));

        return getOutputData();
    }

}
package org.yawlfoundation.yawl.resourcing.codelets;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import org.jdom2.Element;
import org.yawlfoundation.yawl.elements.data.YParameter;

/**
 *
 * @author simon
 */
public class SurveyAdherence extends AbstractCodelet {
    
    
    public SurveyAdherence() {
        
        super();
        setDescription("This codelet open the pdf of the survey asking <br>"
                + "the patient about his adherence on the therapy.");  
        
    }
    
    @Override
    public Element execute(Element inData, List<YParameter> inParams, List<YParameter> outParams) throws CodeletExecutionException {
        setInputs(inData, inParams, outParams);
        String trattamento = (String) getParameterValue("trattamento");
        if (trattamento.equals("Trattamento terapia PAP")) {
            if (Desktop.isDesktopSupported()) {
                try {
                    URL url = this.getClass().getResource("/org/yawlfoundation/yawl/resourcing/codelets/questionarioAderenza.pdf");
                    Desktop.getDesktop().browse(url.toURI());
                } catch (IOException | URISyntaxException ex) {}
            }
        }
        return getOutputData();
    }

}

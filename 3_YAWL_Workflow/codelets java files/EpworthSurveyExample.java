
package org.yawlfoundation.yawl.resourcing.codelets;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jdom2.Element;
import org.yawlfoundation.yawl.elements.data.YParameter;

/**
 *
 * @author simon
 */
public class EpworthSurveyExample extends AbstractCodelet {
    
    JFrame gui = new JFrame();
    JPanel pane = new JPanel();
    JLabel back = new JLabel();
    
    public EpworthSurveyExample() {
        
        super();
        setDescription("This codelet show to the user the standard epworth <br>"
                + "survey with a 0-3 points scale in order to evaluate the <br>"
                + "sleepiness entity in order to stimate a clinical condition.");
        
    }
    
    @Override
    public Element execute(Element inData, List<YParameter> inParams, List<YParameter> outParams) throws CodeletExecutionException {
        
        setInputs(inData, inParams, outParams);

        ImageIcon img = new ImageIcon(this.getClass().getResource("/org/yawlfoundation/yawl/resourcing/codelets/epworthsurvey_1.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(773, 898, Image.SCALE_SMOOTH));
        back.setIcon(img);
        pane.add(back);
        gui.setSize(773, 898);
        gui.getContentPane().add(pane);
        gui.setResizable(false);
        gui.setVisible(true);        
        return getOutputData();
    }

}


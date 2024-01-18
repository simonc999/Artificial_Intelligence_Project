
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
public class LifestyleBanner extends AbstractCodelet {
    
    JFrame gui = new JFrame();
    JPanel pane = new JPanel();
    JLabel back = new JLabel();
    
    public LifestyleBanner() {
        
        super();
        setDescription("This codelet designs an informative pamphlet to <br>"
                + "instruct the patient about what he needs to do for a <br>"
                + "correct treatment of his sleep apnea condition at home.");
        
    }
    
    @Override
    public Element execute(Element inData, List<YParameter> inParams, List<YParameter> outParams) throws CodeletExecutionException {
        
        setInputs(inData, inParams, outParams);

        ImageIcon img = new ImageIcon(this.getClass().getResource("/org/yawlfoundation/yawl/resourcing/codelets/lifestylemodifications.png"));
        img = new ImageIcon(img.getImage().getScaledInstance(1241, 620, Image.SCALE_SMOOTH));
        back.setIcon(img);
        pane.add(back);
        
        gui.setSize(1241, 650);
        gui.getContentPane().add(pane);
        gui.setResizable(false);
        gui.setVisible(true);
        
        
        return getOutputData();
    }
    
}


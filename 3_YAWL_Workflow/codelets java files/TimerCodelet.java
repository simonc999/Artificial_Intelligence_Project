package org.yawlfoundation.yawl.resourcing.codelets;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import org.jdom2.Element;
import org.yawlfoundation.yawl.elements.data.YParameter;

/**
 *
 * @author simon
 */
public class TimerCodelet extends AbstractCodelet {
    
    JFrame gui = new JFrame();
    JPanel pane = new JPanel();
    public TimerCodelet() throws MalformedURLException {
        
        super();
        setDescription("10 seconds gif hourglass!");
    }
    
    
    
    @Override
    public Element execute(Element inData, List<YParameter> inParams, List<YParameter> outParams) throws CodeletExecutionException {
        
        setInputs(inData, inParams, outParams);
        pane.setLayout(new BorderLayout());

        
        ImageIcon img = new ImageIcon(this.getClass().getResource("/org/yawlfoundation/yawl/resourcing/codelets/timer.gif"));
        JLabel back = new JLabel(img);
        
        JLabel back1 = new JLabel("ONE MONTH LATER...",SwingConstants.CENTER);
        back1.setFont(new Font("Arial", Font.BOLD, 20));

        pane.add(back1, BorderLayout.NORTH);

        pane.add(back, BorderLayout.SOUTH);

        gui.setSize(320, 320);
        gui.getContentPane().add(pane);
        gui.setResizable(false);
        gui.setVisible(true);

        Timer timer = new Timer(10000, (ActionEvent evt) -> {
            gui.dispose();
        });
        timer.setRepeats(false);
        timer.start();
        
        
        return getOutputData();
    }

    
   
    
}

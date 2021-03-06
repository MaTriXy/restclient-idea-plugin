/**
 * The MIT License
 *
 * Copyright (c) 2011 by Dustin R. Callaway
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.wiztools.restclient.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creates the about plugin dialog.
 */
class AboutPluginDialog extends EscapableDialog
{
    private static final String PLUGIN_TITLE = "RESTClient IDEA Plugin";
    private static final String PLUGIN_VERSION = "1.1";
    private static final String AUTHOR = "Dustin R. Callaway";
    private static final String EMAIL = "drcallaway@gmail.com";
    private static final String AUTHOR_URL = "http://www.sourcestream.com";
    private static final String PLUGIN_URL = "http://restclient-idea-plugin.googlecode.com";
    private static final String OPEN_SOURCE_LICENSE = "MIT License";
    private static final String ICONS = "Courtesty of Nuvola 1.0 (KDE 3.x icon set),<br>" +
        "Tango Icon Library 0.8.90, Wikimedia Commons";

    private AboutPluginDialog me;

    /**
     * Constructs a new AboutPluginDialog object.
     *
     * @param frame Frame
     */
    public AboutPluginDialog(Frame frame)
    {
        super(frame, true);
        me = this;
        init();
    }

    /**
     * Initializes the dialog box.
     */
    private void init()
    {
        setTitle("About Plugin");

        JPanel jp = new JPanel();
        jp.setBorder(BorderFactory.createEmptyBorder(RESTView.BORDER_WIDTH, RESTView.BORDER_WIDTH,
            RESTView.BORDER_WIDTH, RESTView.BORDER_WIDTH));
        jp.setLayout(new BorderLayout());

        JPanel jp_north = new JPanel();
        jp_north.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel jl_title = new JLabel(
            "<html><h2>" + PLUGIN_TITLE + " " + PLUGIN_VERSION + "</h2></html>");
        jp_north.add(jl_title);
        jp.add(jp_north, BorderLayout.NORTH);

        JPanel jp_center = new JPanel();
        jp_center.setLayout(new GridLayout(1, 1));
        JTextPane jtp = new JTextPane();
        jtp.setEditable(false);
        jtp.setContentType("text/html");
        jtp.setText("<p style='font-family: Arial, sans-serif'><b>Author:</b> " + AUTHOR + "<br><br>" +
            "<b>Email:</b> " + EMAIL + "<br><br>" +
            "<b>Author Website:</b> " + AUTHOR_URL + "</a><br><br>" +
            "<b>Plugin Website:</b> " + PLUGIN_URL + "<br><br>" +
            "<b>Open Source License:</b> " + OPEN_SOURCE_LICENSE + "<br><br>" +
            "<table border='0' style='font-family: Arial, sans-serif' cellspacing='0' cellpadding='0'>" +
            "<tr valign='top'><td><b>Icons:</b>&nbsp;</td><td>" +  ICONS + "</td></tr></table><br></p>");
        jp_center.add(new JScrollPane(jtp));
        jp.add(jp_center, BorderLayout.CENTER);

        JPanel jp_south = new JPanel();
        jp_south.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton jb_ok = new JButton("Ok");
        jb_ok.setMnemonic('o');
        jb_ok.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                hideMe();
            }
        });
        jp_south.add(jb_ok);
        jp.add(jp_south, BorderLayout.SOUTH);

        setContentPane(jp);

        pack();
    }

    /**
     * Overrides the EscapableDialogBox's doEscape() method.
     *
     * @param event AWTEvent
     */
    @Override
    public void doEscape(AWTEvent event)
    {
        hideMe();
    }

    /**
     * Hides the dialog box.
     */
    public void hideMe()
    {
        me.setVisible(false);
    }
}

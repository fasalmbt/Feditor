package Feditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class NotePad {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Feditor");
		JTextArea tarea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		JMenu editmenu = new JMenu("Edit");
		JMenu helpmenu = new JMenu("Help");
		JMenuItem newitem = new JMenuItem("New");
		JMenuItem openitem = new JMenuItem("Open File");
		JMenuItem saveitem = new JMenuItem("Save");
		JMenuItem exititem = new JMenuItem("Exit");
		JMenuItem copyitem = new JMenuItem("Copy");
		JMenuItem pasteitem = new JMenuItem("Paste");
		JMenuItem selectitem = new JMenuItem("Select All");
		JMenuItem docsitem = new JMenuItem("Docs");
		JMenuItem contributeitem = new JMenuItem("Contribute");
		JMenuItem aboutitem = new JMenuItem("About");
		docsitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frame, "Want to read the docs?");
				String urldocs = "https://github.com/fasalmbt/Feditor/blob/main/README.md";
				if(check == JOptionPane.YES_OPTION) {
					try {
				        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				            desktop.browse(new URI(urldocs));
				        }
				        throw new NullPointerException();
				    } catch (Exception ex) {
				        
				    }
				}
			}
		});
		aboutitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Feditor is a minimal opensource text editor.");
			}
		});
		contributeitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int check = JOptionPane.showConfirmDialog(frame, "Are you willing to contribute to Feditor repository?");
				String url = "https://github.com/fasalmbt/Feditor";
				if(check == JOptionPane.YES_OPTION) {
					try {
				        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				        if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				            desktop.browse(new URI(url));
				        }
				        throw new NullPointerException();
				    } catch (Exception ex) {}
				}
			}
		});
		tarea.setEditable(true);
		frame.add(tarea);
		frame.setSize(600,600);
		frame.setVisible(true);
		menuBar.add(filemenu);
		menuBar.add(editmenu);
		menuBar.add(helpmenu);
		filemenu.add(newitem);
		filemenu.add(openitem);
		filemenu.add(saveitem);
		filemenu.add(exititem);
		editmenu.add(copyitem);
		editmenu.add(pasteitem);
		editmenu.add(selectitem);
		helpmenu.add(docsitem);
		helpmenu.add(contributeitem);
		helpmenu.add(aboutitem);
		frame.setJMenuBar(menuBar);
	}
}

package Feditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.Desktop;
import java.net.URI;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;


public class NotePad {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Feditor");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		JTextArea tarea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		JMenu filemenu = new JMenu("File");
		JMenu editmenu = new JMenu("Edit");
		JMenu helpmenu = new JMenu("Help");
		JMenuItem openitem = new JMenuItem("Open File");
		JFileChooser fopenc = new JFileChooser();
		JMenuItem saveitem = new JMenuItem("Save");
		JMenuItem exititem = new JMenuItem("Exit");
		JMenuItem copyitem = new JMenuItem("Copy");
		JMenuItem cutitem = new JMenuItem("Cut");
		JMenuItem pasteitem = new JMenuItem("Paste");
		JMenuItem selectitem = new JMenuItem("Select All");
		JMenuItem docsitem = new JMenuItem("Docs");
		JMenuItem contributeitem = new JMenuItem("Contribute");
		JMenuItem aboutitem = new JMenuItem("About");
		openitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int opencheck = fopenc.showOpenDialog(null);
				if(opencheck == JFileChooser.APPROVE_OPTION) {
					File fil = new File(fopenc.getSelectedFile().getAbsolutePath());
					try {
						String str1 = "", sringlen = "";
						FileReader freader = new FileReader(fil);
						BufferedReader breader = new BufferedReader(freader);
						sringlen = breader.readLine();
						while((str1 = breader.readLine()) != null) {
							sringlen = sringlen + '\n' + str1;
						}
						tarea.setText(sringlen);
						breader.close();
					}
					catch (Exception evt1) {
						JOptionPane.showMessageDialog(frame, evt1.getMessage());
					}
				}
			}
		});
		saveitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int savecheck = fopenc.showSaveDialog(null);
				if(savecheck == JFileChooser.APPROVE_OPTION) {
					File fil = new File(fopenc.getSelectedFile().getAbsolutePath());
					try {
	                    FileWriter fwriter = new FileWriter(fil, false);
	                    BufferedWriter bwriter = new BufferedWriter(fwriter);
	                    bwriter.write(tarea.getText());
	                    bwriter.flush();
	                    bwriter.close();
	                }
	                catch (Exception evt) {
	                    JOptionPane.showMessageDialog(frame, evt.getMessage());
	                }
				}
				
			}
		});
		exititem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);			}
		});
		copyitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tarea.copy();
			}
		});
		cutitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tarea.cut();
			}
		});
		pasteitem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				tarea.paste();
			}
		});
		selectitem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tarea.selectAll();
			}
		});
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
		filemenu.add(openitem);
		filemenu.add(saveitem);
		filemenu.add(exititem);
		editmenu.add(copyitem);
		editmenu.add(cutitem);
		editmenu.add(pasteitem);
		editmenu.add(selectitem);
		helpmenu.add(docsitem);
		helpmenu.add(contributeitem);
		helpmenu.add(aboutitem);
		frame.setJMenuBar(menuBar);
	}
}


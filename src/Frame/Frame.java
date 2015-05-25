package Frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFrame;

import Tree.CreateTree;
import Tree.LinkedBinaryTree;
import Tree.Position;

import com.sun.glass.events.MouseEvent;

import java.awt.event.*;
import java.awt.*;
import java.util.Stack;


public class Frame extends JFrame{
	JDesktopPane jdpDesktop;
	static int openFrameCount = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = -2706070701008251356L;



	public Frame(){
		super("Expression to Tree");
		int inset = 50;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds(inset, inset, screenSize.width - inset * 2,screenSize.height - inset * 2);
		addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		jdpDesktop = new JDesktopPane();
		createFrame(); // Create first window
		setContentPane(jdpDesktop);
		setJMenuBar(createMenuBar());
		jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");
		setVisible(true);
	}
	protected JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Frame");
		menu.setMnemonic(KeyEvent.VK_N);
		JMenuItem menuItem = new JMenuItem("New IFrame");
		menuItem.setMnemonic(KeyEvent.VK_N);
		menuItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				createFrame();
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		return menuBar;
		
	}
	protected void createFrame() {
		MyInternalFrame frame = new MyInternalFrame();
		frame.setVisible(true);
		// Every JInternalFrame must be added to content pane using JDesktopPane
		jdpDesktop.add(frame);
		try {
			frame.setSelected(true);
		} catch (java.beans.PropertyVetoException e) {
		}
	}
//	protected void printcreateFrame() {
//		MyInternalFrame frame = new MyInternalFrame();
//		frame.setVisible(true);
//		// Every JInternalFrame must be added to content pane using JDesktopPane
//		jdpDesktop.add(frame);
//		try {
//			frame.setSelected(true);
//		} catch (java.beans.PropertyVetoException e) {
//		}
//	}
	public static void inorder(Position<String> p, LinkedBinaryTree<String> tree)
	 {
		
	  if (p != null)
	  {
	   inorder(tree.left(p), tree);
	   System.out.print(tree.getElement(p)+" ");
	   inorder(tree.right(p), tree);
	   
	  }
	 }
	class MyInternalFrame extends JInternalFrame {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		static final int xPosition = 30, yPosition = 30;
		public MyInternalFrame() {
			super("IFrame #" + (++openFrameCount), true, // resizable
					true, // closable
					true, // maximizable
					true);// iconifiable
			setSize(300, 300);
			// Set the window's location.
			setLocation(xPosition * openFrameCount, yPosition
					* openFrameCount);
			JTextArea text=new JTextArea();
			JScrollPane scrollPane = new JScrollPane(text);
			text.setText("Please enter the expression:");
			text.setEditable(false);
			add(text,BorderLayout.NORTH);
			JTextArea ta = new JTextArea(); 
			String input = ta.getText();
			add(ta, BorderLayout.CENTER);
			JButton button = new JButton(" Calculate");
			button.setMnemonic(KeyEvent.VK_M);
			add(button,BorderLayout.SOUTH);
			JTextArea Tree= new JTextArea();
			button.doClick();
			button.addMouseListener(new MouseListener(){
				private void actionPerformed(MouseEvent e){
					
				}

				@Override
				public void mouseClicked(java.awt.event.MouseEvent arg0) {
					CreateTree tree= new CreateTree(ta.getText());
					LinkedBinaryTree<String> Bintree= tree.getTree();
					Position<String> p = Bintree.root();
					
					inorder(p,Bintree);
				}
				@Override
				public void mouseEntered(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseExited(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mousePressed(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(java.awt.event.MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
			});
		
		 
		}
	}
}

		
		
	



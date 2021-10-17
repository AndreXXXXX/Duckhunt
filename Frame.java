import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.DataLine.Info;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JPanel implements ActionListener, MouseListener {
	
	//Objects that need to be drawn on the JFrame in the paint method.
	Duck d = new Duck();
	Tree t = new Tree();
	Ground ground = new Ground();
	Dog dog = new Dog();
	boolean show = false;
	int counter = 3;
	
	//draws the duck, tree, ground, and dog
	public void paint(Graphics g) {
		super.paintComponent(g);
		d.paint(g);
		t.paint(g);
		ground.paint(g);
		if (show) {
			dog.paint(g);
		}
	}
	
	
	public static void main(String[] arg) {
		Frame f = new Frame();
		
	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(900, 600));
		f.setBackground(Color.blue);
		f.add(this);
		f.addMouseListener(this);
		f.setResizable(false);
		
		Timer t = new Timer(16, this);
	
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//plays the thud sound when mouse is clicked
		try {
	        Clip thud = AudioSystem.getClip();
	        URL url = this.getClass().getClassLoader().getResource("Thud.wav");

	        AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
	        thud.open(audioIn);
	        thud.start();
	        } catch(Exception e) {
	    }
		//finds if you hit the duck, and if you don't hit it, counter goes down by 1 from 3 until it 
		//gets to 1, and when it gets to 1, it shows the picture of the dog
		int x = arg0.getX();
		int y = arg0.getY();
		if(!d.collide(x,y)) {
			counter--;
			if(counter == 1) {
				counter = 3;
				show = true;
			}
			
		} 
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}

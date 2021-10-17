import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Duck implements MouseListener{
	private int x = 350,y = 280;
	private int vx = (int)(Math.random()*(15))+12, vy = 15;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Duck() {
		img = getImage("duck2.gif"); //load the image for Tree
		init(x, y); 				//initialize the location of the image
	}
	
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		
		//if the duck passes through the top, it gets reset to the bottom of the screen
		//if the duck hits the left or right sides of the screen then its velocity reverses
		x += vx;
		y -= vy;
		
		if ( y <=-150 ) {
			y = 500;
			x = (int)(Math.random()*(780-0+1))+0;
		}
		if ( x <= -100 || x >= 780) {
			vx *=-1;
		}
		tx.setToTranslation(x, y);
		g2.drawImage(img, tx, null);   
		
	}
	
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}
	
	

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Duck.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
	
	private Rectangle getBoundary() {
		return new Rectangle(x, y, img.getWidth(null), img.getHeight(null));
	}
	
	public boolean collide(int x, int y) {
	return	this.getBoundary().contains(x,y);
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
		System.out.println("ouch");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

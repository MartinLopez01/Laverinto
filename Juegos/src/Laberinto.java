import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Laberinto {

	private JFrame frame;

	public int jugadorx = 260;
	public int jugadory = 160;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Laberinto window = new Laberinto();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Laberinto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setFocusable(true);
		frame.requestFocus();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		frame.getContentPane().add(panel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("Reiniciar");
		panel.add(btnNewButton);

		JPanel juego = new JPanel();
		juego.setBackground(new Color(187, 0, 187));
		frame.getContentPane().add(juego, BorderLayout.CENTER);

		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				// System.out.println(e.getKeyCode());
				System.out.println(e.getKeyChar());

				if (e.getKeyChar() == 'w' && jugadory > 0) {
					jugadory -= 10;
				}
				if (e.getKeyChar() == 's' && jugadory < 370) {
					jugadory += 10;
				}
				if (e.getKeyChar() == 'd' && jugadorx < 480) {
					jugadorx += 10;
				}
				if (e.getKeyChar() == 'a' && jugadorx > 0) {
					jugadorx -= 10;
				}
				juego.repaint();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		juego.add(new MyGraphics());
		juego.setFocusable(true);
		juego.requestFocus();

	}

	public class MyGraphics extends JComponent {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		MyGraphics() {
			setPreferredSize(new Dimension(500, 400));
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, 500, 400);
			Rect j = new Rect(jugadorx, jugadory, 20, 20, new Color(1, 1, 1));

			g.setColor(j.c);
			g.fillRect(j.x, j.y, j.w, j.h);

			Rect r = new Rect(324, 122, 120, 120, new Color(145, 122, 141));

			g.setColor(r.c);
			g.fillRect(r.x, r.y, r.w, r.h);

			System.out.println(j.colision(r));
		}
	}

	public class Rect {
		int x = 0;
		int y = 0;
		int w = 0;
		int h = 0;
		Color c = Color.BLACK;

		Rect(int x, int y, int w, int h, Color c) {
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
			this.c = c;
		}

		public boolean colision(Rect target) {
			if (this.x < target.x + target.w && this.x + this.w > target.x && this.y < target.y + target.h
					&& this.y + this.h > target.h) {
				return true;
			}

			return false;

		}

	}

}

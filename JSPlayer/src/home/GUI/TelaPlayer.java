package home.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import home.negocio.CustomPlayer;
import home.negocio.beans.Musica;

import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;

public class TelaPlayer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaPlayer(Musica m) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		CustomPlayer p = new CustomPlayer();
		
		p.setPath(m.getEndereco());

		setResizable(false);
		setTitle("Player");
		setUndecorated(true);
		setBounds(100, 100, 301, 182);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBorder(new TitledBorder(null, "Player", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, null,
				new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		p.play(-1);
		JToggleButton tglbtnPlay = new JToggleButton("Play/Pause");
		tglbtnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (tglbtnPlay.isSelected()) {
					p.pause();
				} else {
					p.resume();
				}
			}
		});
		tglbtnPlay.setBounds(12, 39, 137, 25);
		contentPane.add(tglbtnPlay);

		JButton btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p.getPlayer().close();
				p.play(-1);
				p.pause();
			}
		});
		btnStop.setBounds(12, 77, 97, 25);
		contentPane.add(btnStop);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				p.getPlayer().close();
			}
		});
		btnFechar.setBounds(192, 144, 97, 25);
		contentPane.add(btnFechar);
	}

}

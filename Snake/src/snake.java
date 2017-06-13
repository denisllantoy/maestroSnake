
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class Snake extends JFrame implements KeyListener, Runnable {
    JPanel p1, p2;
    JButton[] lb = new JButton[200];
    JButton bonusfood;
    JTextArea t;
    int x = 500, y = 250, gu = 2, directionx = 1, directiony = 0, speed = 50, difference = 0, oldx, oldy, score = 0;
    int[] lbx = new int[300];
    int[] lby = new int[300];
    Point[] lbp = new Point[300];
    Point bfp = new Point();
    Thread myt;
    boolean food = false, runl = false, runr = true, runu = true, rund = true, bonusflag = true;
    Random r = new Random();
    JMenuBar mymbar;
    JMenu game, help, level;

    public void initializeValues() { 
        gu = 3;
        lbx[0] = 100;
        lby[0] = 150;
        directionx = 10;
        directiony = 0;
        difference = 0;
        score = 0;
        food = false;
        runl = false;
        runr = true;
        runu = true;
        rund = true;
        bonusflag = true;
    }
    Snake() {
        super("Snake");
        setSize(500, 330);
        //Crear barra de menú con funciones
        creatbar();
        //inicializar todas las variables
        initializeValues();
        // Inicio de diseño de interfaz de usuario
        p1 = new JPanel();
        p2 = new JPanel();       
        // t va a ver la puntuación
        t = new JTextArea("Score ==>" + score);
        t.setEnabled(false);
        t.setBackground(Color.BLACK);
        //erpiente debe comer bonousfood a growup
        bonusfood = new JButton();
        bonusfood.setEnabled(false);
        // harán primer serpient
        createFirstSnake();
        p1.setLayout(null);
        p2.setLayout(new GridLayout(0, 1));
        p1.setBounds(0, 0, x, y);
        p1.setBackground(Color.blue);
        p2.setBounds(0, y, x, 30);
        p2.setBackground(Color.RED);

        p2.add(t); // contiene tabla de puntuaciones
        //final del diseño de la interfaz de usuario
        getContentPane().setLayout(null);
        getContentPane().add(p1);
        getContentPane().add(p2);
        show();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
        // INICIAR thread
        myt = new Thread(this);
        myt.start(); // ir a run() method
    }
    public void createFirstSnake() {
        // Inicialmente tiene la serpiente pequeña length 3
        for (int i = 0; i < 3; i++) {
            lb[i] = new JButton("lb" + i);
            lb[i].setEnabled(false);
            p1.add(lb[i]);
            lb[i].setBounds(lbx[i], lby[i], 10, 10);
            lbx[i + 1] = lbx[i] - 10;
            lby[i + 1] = lby[i];
        }
    }

    public void creatbar() {
        mymbar = new JMenuBar();

        game = new JMenu("jugar");

        JMenuItem newgame = new JMenuItem("nuevo juego");
        JMenuItem exit = new JMenuItem("salir");

        newgame.addActionListener(
                new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                       
                    }
                });

        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        game.add(newgame);
        game.addSeparator();
        game.add(exit);

        mymbar.add(game);

        level = new JMenu("nivel");

        mymbar.add(level);

        help = new JMenu("ayuda");
        
        JMenuItem creator = new JMenuItem("creador");
        JMenuItem instruction = new JMenuItem("instruccion");

        creator.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(p2, "nombre :denis\nuniversidad :unajma");
            }
        });

        help.add(creator);
        help.add(instruction);
        mymbar.add(help);

        setJMenuBar(mymbar);
    }

    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
  
}

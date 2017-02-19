import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarView extends JFrame implements ViewInterface {
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member
    DrawPanel drawPanel;
    ArrayList<EventHandlerInterface> handlers = new ArrayList<>();
    int gasAmount = 0;

    JPanel controlPanel = new JPanel();
    JPanel gasPanel = new JPanel();

    JSpinner gasSpinner = new JSpinner();
    JLabel gasLabel = new JLabel("Amount of gas");

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    // Constructor
    public CarView(String framename) {
        drawPanel = new DrawPanel(X, Y - 240);
        initComponents(framename);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        drawPanel.addVehicle(vehicle);
    }

    @Override
    public void registerEventHandler(EventHandlerInterface handler) {
        handlers.add(handler);
    }

    @Override
    public float getWorldHeight() { return 500; }

    @Override
    public float getWorldWidth() { return 680; }

    @Override
    public void renderWorld() {
        drawPanel.repaint();
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X, Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);


        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2, 4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);

        // This actionListener is for the gas button only
        // TODO: Create more for each component as necessary
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(gasAmount);
            }
        });
        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(gasAmount);
            }
        });

        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOff();
            }
        });

        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turboOn();
            }
        });

        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startAll();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopAll();
            }
        });


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Event handler



    public void brake(int amount) {
        double brake = (double) amount / 2.0;
        for (EventHandlerInterface handler : handlers) {
            handler.onBrake(brake);
        }
    }

    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (EventHandlerInterface handler : handlers) {
            handler.onGas(gas);
        }
    }

    public void turboOn() {
        for (EventHandlerInterface handler : handlers) {
            handler.onTurboToggle(true);
        }
    }

    public void turboOff() {
        for (EventHandlerInterface handler : handlers) {
            handler.onTurboToggle(false);
        }
    }

    public void liftBed() {
        for (EventHandlerInterface handler : handlers) {
            handler.onFlatbedToggle(true);
        }
    }

    public void lowerBed() {
        for (EventHandlerInterface handler : handlers) {
            handler.onFlatbedToggle(false);
        }
    }

    public void startAll() {
        for (EventHandlerInterface handler : handlers) {
            handler.onEngineToggle(true);
        }
    }

    public void stopAll() {
        for (EventHandlerInterface handler : handlers) {
            handler.onEngineToggle(false);
        }
    }
}
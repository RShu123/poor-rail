package hu.frameworkpattern.poorrail.Gui;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import hu.frameworkpattern.poorrail.Commandpattern.*;
import hu.frameworkpattern.poorrail.Domain.Locomotief;
import hu.frameworkpattern.poorrail.Domain.RailVehicle;
import hu.frameworkpattern.poorrail.Domain.Train;
import hu.frameworkpattern.poorrail.Domain.Wagon;
import hu.frameworkpattern.poorrail.Factory.LocomotiefFactory;
import hu.frameworkpattern.poorrail.Factory.WagonFactory;
import hu.frameworkpattern.poorrail.Persistence.JsonConvert;
import hu.frameworkpattern.poorrail.Persistence.LoadSave;
import hu.frameworkpattern.poorrail.Persistence.Write;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

//import org.json.JSONArray;
//import org.json.JSONObject;
//import com.sun.javafx.scene.paint.GradientUtils.Parser;

public class RichRail extends JFrame {

    private JPanel contentPane;
    private JTextField inputField;
    private JButton executeBtn;
    private JPanel drawPanel;
    private JPanel commandPanel;
    public static JPanel outputPanel;
    private int currentNumberOfCommands;
    private String treinNaam;
    private String wagonNaam;
    private String commandType;
    public static int currentNumberOfOutputs;
    private long aantalStoelen;
    private int aantalTreinStoelen;
    private int OFFSET = 100;
    private int TRAINLENGTH = 100;
    private int currentTrain = -1;
    private int currentNumberOfWagons;

    public static WagonFactory wagonFactory = new WagonFactory();
    public static LocomotiefFactory locomotiefFactory = new LocomotiefFactory();

    private int wagonPosition;

    public ArrayList<Train> Treinen = new ArrayList<>();
    public ArrayList<Wagon> Wagons = new ArrayList<>();

    public JSONObject jobTrain = new JSONObject();
    public JSONObject jobWagon = new JSONObject();



    private LoadSave loader = new LoadSave();
    private JsonConvert converter = new JsonConvert();
    private Write writer = new Write();

    public RichRail() {
        //loader = newLoad;
        //converter = newConvert;
        setResizable(false);
        setTitle("RichRail");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 805, 690);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        contentPane.add(drawPanel, BorderLayout.NORTH);
        GridBagLayout gbl_drawPanel = new GridBagLayout();
        gbl_drawPanel.columnWidths = new int[]{40};
        gbl_drawPanel.rowHeights = new int[]{400};
        gbl_drawPanel.columnWeights = new double[]{Double.MIN_VALUE};
        gbl_drawPanel.rowWeights = new double[]{Double.MIN_VALUE};
        drawPanel.setLayout(gbl_drawPanel);

        outputPanel = new JPanel();
        outputPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        outputPanel.setBackground(Color.BLACK);
        contentPane.add(outputPanel, BorderLayout.EAST);
        outputPanel.setLayout(new GridLayout(0, 20, 15, 0));


        commandPanel = new JPanel();
        commandPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        commandPanel.setBackground(Color.WHITE);
        contentPane.add(commandPanel, BorderLayout.WEST);
        commandPanel.setLayout(new GridLayout(0, -20, -14, 0));

        JLabel lblOutput = DefaultComponentFactory.getInstance().createLabel("output:");
        lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblOutput, BorderLayout.CENTER);

        JPanel lowPanel = new JPanel();
        FlowLayout fl_lowPanel = (FlowLayout) lowPanel.getLayout();
        fl_lowPanel.setAlignment(FlowLayout.LEFT);
        contentPane.add(lowPanel, BorderLayout.SOUTH);

        JLabel lblCommand = new JLabel("command:");
        lowPanel.add(lblCommand);

        inputField = new JTextField();
        inputField.setHorizontalAlignment(SwingConstants.LEFT);
        lowPanel.add(inputField);
        inputField.setColumns(10);

        executeBtn = new JButton("execute");
        executeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (event.getSource() == executeBtn) {
                    String input = inputField.getText();
                    currentNumberOfCommands += 20;
                    try {
                        printCommand(input);
                    } catch (JSONException | ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

            }
        });
        lowPanel.add(executeBtn);

        initializeVehicles();
    }

    public void printCommand(String command) throws JSONException, ParseException {
        Graphics output = outputPanel.getGraphics();
        output.setColor(Color.white);
        try {
            Locomotief loco = null;
            Wagon wagon = null;
            loco = locomotiefFactory.makeLocomotief(command);
            wagon = wagonFactory.makeWagon(command);
            if (!(loco == null)) {
                drawTrain(loco.getNaam());
                currentNumberOfOutputs += 20;
                output.drawString("train " + loco.getNaam() + " created", 5, currentNumberOfOutputs);
            }
            if (!(wagon == null)) {
                currentNumberOfOutputs += 20;
                output.drawString("wagon " + wagon.getNaam() + " created", 5, currentNumberOfOutputs);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            output.setColor(Color.red);
            currentNumberOfOutputs += 20;
            output.drawString("commando is niet volgens het juiste format", 5, currentNumberOfOutputs);
        }


        Graphics g = commandPanel.getGraphics();
        g.drawString(command, 5, currentNumberOfCommands);
        String[] splitted = command.split(" ");


        if (command.startsWith("getnumseats train")) {
            ArrayList<Locomotief> locomotieven = locomotiefFactory.getList();
            treinNaam = splitted[2];

            for (Locomotief loco : locomotieven) {
                if (loco.getNaam().equals(treinNaam)) {
                    GetNumSeatsLocomotief numberOfSeats = new GetNumSeatsLocomotief(loco);
                    Use gebruik = new Use(numberOfSeats);
                    gebruik.uitvoeren();
                }
            }
        }

        if (command.startsWith("getnumseats wagon")) {
            ArrayList<Wagon> wagons = wagonFactory.getList();
            wagonNaam = splitted[2];


            for (Wagon w : wagons) {
                if (w.getNaam().equals(wagonNaam)) {
                    GetNumSeatsWagon numberOfSeats = new GetNumSeatsWagon(w);
                    Use gebruik = new Use(numberOfSeats);
                    gebruik.uitvoeren();
                }
            }
        }

        if (command.startsWith("delete train")) {
            treinNaam = splitted[2];
            ArrayList<Locomotief> locomotieven = locomotiefFactory.getList();
            for (Locomotief loco : locomotieven) {
                if (loco.getNaam().equals(treinNaam)) {
                    DeleteLocomotief deleteLoco = new DeleteLocomotief(loco);
                    Use gebruik = new Use(deleteLoco);
                    gebruik.uitvoeren();
                }
            }
        }

        if (command.startsWith("delete wagon")) {
            wagonNaam = splitted[2];
            ArrayList<Wagon> wagons = wagonFactory.getList();
            for (Wagon w : wagons) {
                if (w.getNaam().equals(wagonNaam)) {
                    DeleteWagon deleteWagon = new DeleteWagon(w);
                    Use gebruik = new Use(deleteWagon);
                    gebruik.uitvoeren();
                }
            }
        }

        if (command.startsWith("add")) {
            ArrayList<Locomotief> locomotieven = locomotiefFactory.getList();
            ArrayList<Wagon> wagons = wagonFactory.getList();
            Locomotief loco = null;
            Wagon wag = null;
            wagonNaam = splitted[1];
            treinNaam = splitted[3];
            for (Wagon w : wagons) {
                if (w.getNaam().equals(wagonNaam)) {
                    wag = w;
                }
            }
            for (Locomotief l : locomotieven) {
                if (l.getNaam().equals(treinNaam)) {
                    loco = l;
                }
            }
            AddWagonToTrain addToTrain = new AddWagonToTrain(loco, wag);
            Use gebruik = new Use(addToTrain);
            gebruik.uitvoeren();
        }

        if (command.trim().equals("save")) {
            try {
                writer.writeToFile(locomotiefFactory.getList(), wagonFactory.getList());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (command.trim().equals("load")) {
            loadSave();
        }
    }

    public void loadSave() {
        try {
            loader.loadEverything(wagonFactory.getList(), locomotiefFactory.getList());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void createjsonWagonArray() {
        try {
            converter.createJsonWagonArray(wagonFactory.getList());
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void createjsonTrainArray() {
        try {
            converter.createJsonTrainArray(locomotiefFactory.getList());
        } catch (JSONException | ParseException e) {
            e.printStackTrace();
        }
    }


    public void drawTrain(String train) {
        currentTrain = locomotiefFactory.getListIndex() - 1;
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.YELLOW);
        g.fillRect(30, 80 + currentTrain * OFFSET, 80, 40);
        g.fillRect(80, 60 + currentTrain * OFFSET, 30, 30);
        g.setColor(Color.LIGHT_GRAY);
        g.drawRoundRect(85, 40 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.drawRoundRect(85, currentTrain * OFFSET, 40, 40, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35, 120 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(80, 120 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.drawString(train, 40, 105 + currentTrain * OFFSET);
    }

    public void drawWagon(String wagon, String train) {
        Graphics g = drawPanel.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(40 + currentNumberOfWagons * TRAINLENGTH, 80 + currentTrain * OFFSET, 80, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(45 + currentNumberOfWagons * TRAINLENGTH, 120 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(90 + currentNumberOfWagons * TRAINLENGTH, 120 + currentTrain * OFFSET, 20, 20, 20, 20);
        g.drawString(wagon, 50 + currentNumberOfWagons * TRAINLENGTH, 105 + currentTrain * OFFSET);
        wagonPosition = locomotiefFactory.getList().indexOf(train);
        System.out.println(wagonPosition);
    }

    private void initializeVehicles() {
        RailVehicle r1 = new Train();
        RailVehicle r2 = new Wagon();
        RailVehicle r3 = new Locomotief();

        System.out.println("Trein " + r1.proberenTeBesturen());
        System.out.println("Wagon " + r2.proberenTeBesturen());
        System.out.println("Locomotief " + r3.proberenTeBesturen());
    }


}

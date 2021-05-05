package GUI;

import Operations.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI {
    private JFrame border;
    private JPanel panelView, panelButtons,panelMain;
    private JButton button_9,button_8,button_7,button_6,button_5,button_4,button_3,button_2,button_1,button_0,button_adding, button_subtracting, button_dividing, button_multiplying, button_point, button_equal, button_clear;
    private JTextField text_field;
    private final int width=400,height=500;
    private String number_1=null,number_2=null,number_current=null,equation=null,sign=null;
    private Font font= new Font("Bauhaus 93", Font.PLAIN, 30);


    public static void main(String[] args) {
        MainGUI mainGUI= new MainGUI();
        mainGUI.create();
    }
    public void create(){
        border= new JFrame();
        panelMain=new JPanel();
        panelView= new JPanel();
        panelButtons= new JPanel();
        text_field=new JTextField();
        text_field.setFont(font);
        text_field.setEditable(false);

        button_9= new JButton("9");
        button_8= new JButton("8");
        button_7= new JButton("7");
        button_6= new JButton("6");
        button_5= new JButton("5");
        button_4= new JButton("4");
        button_3= new JButton("3");
        button_2= new JButton("2");
        button_1= new JButton("1");
        button_0= new JButton("0");
        button_adding= new JButton("+");
        button_subtracting= new JButton("-");
        button_dividing= new JButton("/");
        button_multiplying= new JButton("*");
        button_equal= new JButton("=");
        button_point= new JButton(".");
        button_clear= new JButton("C");


        button_9.addActionListener(new ActionButtonNumbers());
        button_8.addActionListener(new ActionButtonNumbers());
        button_7.addActionListener(new ActionButtonNumbers());
        button_6.addActionListener(new ActionButtonNumbers());
        button_5.addActionListener(new ActionButtonNumbers());
        button_4.addActionListener(new ActionButtonNumbers());
        button_3.addActionListener(new ActionButtonNumbers());
        button_2.addActionListener(new ActionButtonNumbers());
        button_1.addActionListener(new ActionButtonNumbers());
        button_0.addActionListener(new ActionButtonNumbers());
        button_point.addActionListener(new ActionButtonNumbers());

        button_adding.addActionListener(new ActionButtonSigns());
        button_subtracting.addActionListener(new ActionButtonSigns());
        button_dividing.addActionListener(new ActionButtonSigns());
        button_multiplying.addActionListener(new ActionButtonSigns());
        button_equal.addActionListener(new ActionButtonSigns());

        button_clear.addActionListener(new ActionButtonClear());

        border.getContentPane().add(BorderLayout.CENTER,panelMain);
        panelMain.setPreferredSize(new Dimension(width,height));
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelView);
        panelMain.add(panelButtons);

        //border.getContentPane().add(BorderLayout.NORTH,panelView);
        panelView.setLayout(new BoxLayout(panelView, BoxLayout.X_AXIS));
        panelView.add(text_field);
        panelView.add(button_clear);
        panelView.setPreferredSize(new Dimension(width,height/5));


        //border.getContentPane().add(BorderLayout.CENTER,panelButtons);
        GridLayout experimentLayout = new GridLayout(4,4);
        panelButtons.setLayout(experimentLayout);
        panelButtons.add(button_7);
        panelButtons.add(button_8);
        panelButtons.add(button_9);
        panelButtons.add(button_dividing);
        panelButtons.add(button_4);
        panelButtons.add(button_5);
        panelButtons.add(button_6);
        panelButtons.add(button_multiplying);
        panelButtons.add(button_3);
        panelButtons.add(button_2);
        panelButtons.add(button_1);
        panelButtons.add(button_subtracting);
        panelButtons.add(button_point);
        panelButtons.add(button_0);
        panelButtons.add(button_equal);
        panelButtons.add(button_adding);
        panelButtons.setPreferredSize(new Dimension(width,4*height/5));

        border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        border.pack();
        border.setSize(width,height);
        border.setVisible(true);
        //border.setResizable(false);

    }
    class ActionButtonNumbers implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String s=e.getActionCommand();

            if(number_current !=null) {
                number_current += s;
                equation += s;
            }
            else {
                number_current= s;
                if(number_1==null)
                    equation= s;
                else
                    equation+=s;
            }
            text_field.setText(equation);
        }
    }
    class ActionButtonSigns implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String s=e.getActionCommand();
            if(number_1==null&&(number_current==null|| number_current.equals("+") || number_current.equals("-"))&&((s.equals("+"))||(s.equals("-")))){
                    number_current = s;
                    equation = s;
            }
            else{
                if(number_1==null) {
                    number_1 = number_current;
                    number_current=null;
                    if(s!="="){
                        equation=number_1+s;
                        sign=s;
                    }

                }
                else if(number_2==null&&number_current==null){
                    if(s!="="){
                        equation=number_1+s;
                        sign=s;
                    }
                }
                else if(number_2==null) {
                    number_2 = number_current;
                    number_current=null;
                    if(s.equals("=")){
                        result();
                        sign=null;
                        number_1=null;
                        number_2=null;
                    }
                    else{
                        result();
                        sign=s;
                        equation+=s;
                        number_1=number_current;
                        number_current=null;
                        number_2=null;
                    }
                }


            }
            text_field.setText(equation);
        }
    }

    private void result() {
        switch (sign){
            case "+":
                equation=Operations.summing(Double.parseDouble(number_1),Double.parseDouble(number_2));
                number_current=equation;
                break;
            case "-":
                equation=Operations.subtracting(Double.parseDouble(number_1),Double.parseDouble(number_2));
                number_current=equation;
                break;
            case "*":
                equation=Operations.multiplying(Double.parseDouble(number_1),Double.parseDouble(number_2));
                number_current=equation;
                break;
            case "/":
                equation=Operations.dividing(Double.parseDouble(number_1),Double.parseDouble(number_2));
                number_current=equation;

                if(equation.equals("Nie dzielimy przez 0")){
                        //equation=null;
                        number_current=null;
                }
                break;

        }
    }

    class ActionButtonClear implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            number_1=null;
            number_2=null;
            number_current=null;
            equation=null;
            sign=null;
            text_field.setText(equation);
        }
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class School {
    public static ArrayList<Student> students;
    public static String[] fields;
    public static JComboBox sort;
    public static String sortType;
    static JLabel error;
    static JTextField name;
    static JTextField DiscussionGrade;
    static JTextField HomeworkGrade;
    static JTextField MidtermGrade;
    static JTextField FinalGrade;
    public static void main(String[] args) throws IOException {
        //Frame
        JFrame frame = new JFrame("School");
        frame.setSize(320, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
        //frame
        sortType = "GPA";
        students = new ArrayList<>();

    }



    public static void addSt(String Name, double DG, double HG, double MG, double FG){
        Student st;
        st = new Student(Name, DG, HG, MG, FG);
        students.add(st);
    }

    public static void addGSt(String Name, double DG, double HG, double MG, double FG){
        Student st;
        st = new GraduateStudent(Name, DG, HG, MG, FG);
        students.add(st);
    }

    public static void loadFromFile(String stType) throws IOException {

        Scanner sc = new Scanner(new File("file.txt"));
        String tall;
        while (sc.hasNextLine()){
            tall = sc.nextLine();
            String[] line;
            line = tall.split(" ", 5);
            if (stType == "St")
            students.add(new Student(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
            else
                students.add(new GraduateStudent(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4])));
        }
        sc.close();
    }




    public static void bubbleSort(String sortBy){
        Student[] st = new Student[students.size()];
        for (int i = 0; i < st.length; i++) {
            st[i] = students.get(i);
        }

        switch (sortBy){
            case "GPA" : sortByGradePointAverage(st);break;
            case "Name" : sortByName(st);break;
            case "DG" : sortByDiscussionGrade(st);break;
            case "HG" : sortByHomeworkGrade(st);break;
            case "MG" : sortByMidtermGrade(st);break;
            case "FG" : sortByFinalGrade(st);break;
        }
        deleteSt();

        for (int i = 0; i < st.length; i++) {
            students.add(0, st[i]);
        }


}

    public static void sortByGradePointAverage(Student[] st){
        for(int i = st.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( st[j].getGradePointAverage() > st[j+1].getGradePointAverage() ){
                    Student tmp = st[j];
                    st[j] = st[j+1];
                    st[j+1] = tmp;
                }
            }
        }
    }

    public static void sortByDiscussionGrade(Student[] st){
        for(int i = st.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( st[j].getDiscussionGrade() > st[j+1].getDiscussionGrade() ){
                    Student tmp = st[j];
                    st[j] = st[j+1];
                    st[j+1] = tmp;
                }
            }
        }
    }

    public static void sortByHomeworkGrade(Student[] st){
        for(int i = st.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( st[j].getHomeworkGrade() > st[j+1].getHomeworkGrade()){
                    Student tmp = st[j];
                    st[j] = st[j+1];
                    st[j+1] = tmp;
                }
            }
        }
    }

    public static void sortByMidtermGrade(Student[] st){
        for(int i = st.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( st[j].getMidtermGrade() > st[j+1].getMidtermGrade()){
                    Student tmp = st[j];
                    st[j] = st[j+1];
                    st[j+1] = tmp;
                }
            }
        }
    }

    public static void sortByFinalGrade(Student[] st){
        for(int i = st.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( st[j].getFinalGrade() > st[j+1].getFinalGrade()){
                    Student tmp = st[j];
                    st[j] = st[j+1];
                    st[j+1] = tmp;
                }
            }
        }
    }

    public static void sortByName(Student[] st){
        for(int i = st.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( st[j].getName().compareTo(st[j+1].getName()) < 0 ){
                    Student tmp = st[j];
                    st[j] = st[j+1];
                    st[j+1] = tmp;
                }
            }
        }
    }

    public static void printSt(){
        System.out.println("******************************");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
        }
        System.out.println("******************************");
    }

    public static void deleteSt(){
        while (students.size() >0){
            students.remove(0);
        }
    }

    public static void placeComponents(JPanel panel) {

        panel.setLayout(null);

        JLabel nameL = new JLabel("Name");
        nameL.setBounds(10, 10, 100, 25);
        panel.add(nameL);

        name = new JTextField(20);
        name.setBounds(120, 10, 180, 25);
        panel.add(name);

        JLabel DiscussionGradeL = new JLabel("Discussion Grade");
        DiscussionGradeL.setBounds(10, 40, 100, 25);
        panel.add(DiscussionGradeL);

        DiscussionGrade = new JTextField(20);
        DiscussionGrade.setBounds(120, 40, 180, 25);
        panel.add(DiscussionGrade);

        JLabel HomeworkGradeL = new JLabel("Homework Grade");
        HomeworkGradeL.setBounds(10, 70, 100, 25);
        panel.add(HomeworkGradeL);

        HomeworkGrade = new JTextField(20);
        HomeworkGrade.setBounds(120, 70, 180, 25);
        panel.add(HomeworkGrade);

        JLabel MidtermGradeL = new JLabel("Midterm Grade");
        MidtermGradeL.setBounds(10, 100, 100, 25);
        panel.add(MidtermGradeL);

        MidtermGrade = new JTextField(20);
        MidtermGrade.setBounds(120, 100, 180, 25);
        panel.add(MidtermGrade);

        JLabel FinalGradeL = new JLabel("Final Grade");
        FinalGradeL.setBounds(10, 130, 100, 25);
        panel.add(FinalGradeL);

        FinalGrade = new JTextField(20);
        FinalGrade.setBounds(120, 130, 180, 25);
        panel.add(FinalGrade);

        JButton printButton = new JButton("print");
        printButton.setBounds(10, 190, 100, 25);
        panel.add(printButton);

        JButton addButton = new JButton("add St");
        addButton.setBounds(210, 160, 85, 25);
        panel.add(addButton);

        JButton addGSButton = new JButton("add G. St");
        addGSButton.setBounds(120, 160, 85, 25);
        panel.add(addGSButton);

        JButton loadStButton = new JButton("load St");
        loadStButton.setBounds(210, 190, 85, 25);
        panel.add(loadStButton);

        JButton loadGStButton = new JButton("load GSt");
        loadGStButton.setBounds(120, 190, 85, 25);
        panel.add(loadGStButton);

        JButton deleteButton = new JButton("delete all");
        deleteButton.setBounds(10, 220, 100, 25);
        panel.add(deleteButton);

        JButton sortBy = new JButton("sort by");
        sortBy.setBounds(120, 220, 85, 25);
        panel.add(sortBy);

        fields = new String[]{"GPA", "Name", "DG", "HG", "FG"};
        sort = new JComboBox(fields);
        sort.setBounds(210, 220, 85, 25);
        panel.add(sort);

        error = new JLabel();
        error.setBounds(10, 160, 100, 25);
        panel.add(error);

        addButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                error.setText("");
                if (!(name.getText().isEmpty() || DiscussionGrade.getText().isEmpty() || HomeworkGrade.getText().isEmpty() || MidtermGrade.getText().isEmpty() || FinalGrade.getText().isEmpty())) {
                    addSt(name.getText(), Integer.parseInt(DiscussionGrade.getText()), Integer.parseInt(HomeworkGrade.getText()), Integer.parseInt(MidtermGrade.getText()), Integer.parseInt(FinalGrade.getText()));
                }
                else {
                    error.setForeground(Color.RED);
                    error.setText("Input error");
                }
            }
        });

        addGSButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                error.setText("");
                if (!(name.getText().isEmpty() || DiscussionGrade.getText().isEmpty() || HomeworkGrade.getText().isEmpty() || MidtermGrade.getText().isEmpty() || FinalGrade.getText().isEmpty())) {
                    addGSt(name.getText(), Integer.parseInt(DiscussionGrade.getText()), Integer.parseInt(HomeworkGrade.getText()), Integer.parseInt(MidtermGrade.getText()), Integer.parseInt(FinalGrade.getText()));
                }
                else{
                    error.setForeground(Color.RED);
                    error.setText("Input error");
                }
            }
        });

        loadStButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    loadFromFile("St");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        loadGStButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    loadFromFile("GSt");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        printButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                printSt();
            }
        });


        deleteButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                deleteSt();
            }
        });

        sortBy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                bubbleSort(sortType);
            }
        });

        sort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) sort.getSelectedItem();

                switch (s) {
                    case "GPA":
                        sortType = "GPA";
                        break;
                    case "Name":
                        sortType = "Name";
                        break;
                    case "DG":
                        sortType = "DG";
                        break;
                    case "HG":
                        sortType = "HG";
                        break;
                    case "MG":
                        sortType = "MG";
                        break;
                    case "FG":
                        sortType = "FG";
                        break;
                }
            }
        });

    }
}

package View;

import Model.ProjectModel;
import Model.Column;
import Model.TaskBoardModel;


import javax.swing.*;
import java.awt.*;
import java.util.*;

public class logInView
{
    JFrame login;
    int rowCount = 0;
    JDialog d;
    private static ArrayList<JTextField> textField = new ArrayList<>();
    private ArrayList<ProjectModel> prModelArray = new ArrayList<>();
    String taskBoardModelName = "TaskBoard1";
    String fileName = " ";
    ProjectModel prModel;
    TaskBoardModel taskBrdModel;

    public logInView(JDialog dialog)
    {
        //login frame
        d = dialog;
        login = new JFrame();
        login.setLayout(new BorderLayout());

        //panel for select project and combobox
        JPanel selectProjectAndComboBox = new JPanel();

        //create label for "Select project"
        JLabel selectProject = new JLabel("Select Project");

        //create combo box

        String[] prOptions = new String[4];
        prOptions[0] = "Project1";

        //dynamically populate it with projects we just created
        for(int i = 1; i < taskBrdModel.getProjectList().size(); i++){
            prOptions[i] = taskBrdModel.getProjectList().get(i).getProjectName();
        }


        JComboBox projectOptionsList = new JComboBox(prOptions);

        //add label and combobox to selectProjectAndComboBox JPanel
        selectProjectAndComboBox.add(selectProject);
        selectProjectAndComboBox.add(projectOptionsList);

        //Create JPanel to hold create new and logout buttons
        JPanel buttons = new JPanel();

        //create buttons
        JButton createNew = new JButton("Create New");
        JButton logout = new JButton("Log Out");

        //add buttons to buttons panel
        buttons.add(createNew);
        buttons.add(logout);

        //Add selectProjectAndComboBox and buttons JPanels to new JPanel
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(selectProjectAndComboBox, BorderLayout.WEST);
        topPanel.add(buttons, BorderLayout.EAST);


        login.add(topPanel, BorderLayout.NORTH);
        login.setSize(1200, 600);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setBackground(Color.LIGHT_GRAY);
        login.setVisible(true);

        //add listener to createNew button
        createNew.addActionListener(e-> {

            // -- in login screen when click Create New - adds a frame in the center 
            createProject();
        });


        //add listener to logout button
        logout.addActionListener(e->{
            //Before closing save user data!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            login.dispose();
            dialog.setVisible(true);



        });

    }
    public int getRowCount()
    {
        return rowCount;
    }

    public void createProject ()
    {
        //createPanel to hold center panel
        JPanel holdCenter = new JPanel(new BorderLayout());
        //create empty border to make center panel centered
        holdCenter.setBorder(BorderFactory.createEmptyBorder(100, 200, 100, 200));

        //create panel for center view
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setPreferredSize(new Dimension(100, 100));
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //create top label
        JLabel createNewProject = new JLabel("Create New Project");
        createNewProject.setHorizontalAlignment(JLabel.CENTER);

        //create JPanel for west view
        JPanel westView = new JPanel(new GridLayout(0, 1, 0,0));

        //create labels
        JLabel name = new JLabel("Name: ");
        JLabel columns = new JLabel("Columns: ");

        //create Text field for name
        JTextField nameText = new JTextField();
        nameText.setPreferredSize(new Dimension(200, 30));

        //create button to add column
        JButton addColumn = new JButton("+");

        //create panel to hold name label and text field
        JPanel holdNameLabelAndTextField = new JPanel();

        //add name label and text field to holdNameLabelAndTextField panel
        holdNameLabelAndTextField.add(name);
        holdNameLabelAndTextField.add(nameText);

        //create panel to hold column label and addColumn button
        JPanel holdColumnLabelAndPlusButton = new JPanel();

        //add column JLabel and plus button to holdColumnLabelAndPlusButton panel
        holdColumnLabelAndPlusButton.add(columns);
        holdColumnLabelAndPlusButton.add(addColumn);

        //add components to west view panel
        westView.add(holdNameLabelAndTextField);
        westView.add(holdColumnLabelAndPlusButton);

        //add west view to center panel and top label
        centerPanel.add(westView, BorderLayout.WEST);
        centerPanel.add(createNewProject, BorderLayout.NORTH);

        //create bottom buttons
        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");

        //Jpanel to hold bottom buttons
        JPanel bottomButtons = new JPanel();

        //JPanel to hold bottombuttons to the right
        JPanel bottomButtonToRight = new JPanel(new BorderLayout());

        //add bottom buttons to bottomButtons Panel
        bottomButtons.add(create);
        bottomButtons.add(cancel);

        //add bottomButtons panel to bottomButtonsToRight panel
        bottomButtonToRight.add(bottomButtons, BorderLayout.EAST);

        //add bottomButtonToRight to center panel
        centerPanel.add(bottomButtonToRight, BorderLayout.SOUTH);

        //add center panel to holdcenter panel
        holdCenter.add(centerPanel, BorderLayout.CENTER);

        login.add(holdCenter, BorderLayout.CENTER);

        login.validate();

        //adding action listener for addColumns button
        addColumn.addActionListener(e->{

            addNewColumn(westView);
        });

        //adding action listener for create button
        create.addActionListener(e -> {
            //Go to view for creating the columns!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        	
        	ArrayList<Column> arrayOfColumn = new ArrayList<Column>();


            //create an ArrayList to store statuses of each task
            for(int i = 0; i<textField.size(); i++ ) {
                Column newCol = new Column(textField.get(i).getText());
                arrayOfColumn.add(newCol);

            }
            //create an instance of ProjectModel class
            prModel = new ProjectModel();
            prModel.setProjectName(nameText.getText());
            prModel.setProjectList(arrayOfColumn);


            //add this object to ArrayList of ProjectModels
            prModelArray.add(prModel);
            taskBrdModel = new TaskBoardModel();
            taskBrdModel.setTaskBoardName(taskBoardModelName);
            taskBrdModel.setProjectList(prModelArray);
            taskBrdModel.setFileName(fileName);

            //login.removeAll();
           login.dispose();
            
           
           // ---- You are creating the new project view here. ----           
           // -----Do something with the arrayOfColumn, prModel, prModelArray, taskBrdModel   
            ProjectView newProject = new ProjectView(d, arrayOfColumn, prModel, taskBrdModel);
           

            JPanel columnsPanel = new JPanel();
            columnsPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 200, 200));
            columnsPanel.setBackground(Color.WHITE);

            login.add(columnsPanel, BorderLayout.WEST);
            //add(columnsPanel, BorderLayout.WEST);


            
            

        });

        //adding action listener for cancel button
        cancel.addActionListener(e->{
            login.dispose();
            new logInView(d);
        });

    }

    private void addNewColumn(JPanel westView)
    {
        if(rowCount < 4){
            JTextField text = new JTextField();
            text.setPreferredSize(new Dimension(150, 30));
            JButton minus = new JButton("-");

            JPanel holdComp = new JPanel();
            holdComp.add(text);
            holdComp.add(minus);

            westView.add(holdComp);

            minus.addActionListener(e-> {
                removeColumn(westView, holdComp);
            });
            rowCount++;
            westView.validate();

            // --- ADD THE 'text' OBJECT TO YOUR LIST! ---
            textField.add(text);
        }
    }

    private void removeColumn(JPanel westView, JPanel holdComp){
        westView.remove(holdComp);

        rowCount--;
        westView.validate();
    }


}

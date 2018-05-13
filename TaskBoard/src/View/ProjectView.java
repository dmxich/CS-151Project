package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Model.*;



public class ProjectView
{
    JFrame  project;
    JDialog dial;

    private JPanel columnsPanel;
    private ArrayList<Column> projectColumns;
    private ProjectModel projectM;
    private TaskBoardModel taskBoardM;

    public ProjectView(JDialog dialog, ArrayList<Column> columns, ProjectModel pm, TaskBoardModel tbm)
    {
        this(dialog);
        this.projectColumns = columns;
        this.projectM = pm;
        this.taskBoardM = tbm;
        createColumnsPanel();
    }

    public ProjectView(JDialog dialog)
    {
        //project page
        project = new JFrame();
        project.setLayout(new BorderLayout());
        dial = dialog;
        //panel for select project and combobox
        JPanel selectProjectAndComboBox = new JPanel();

        //create label for "Select project"
        JLabel selectProject = new JLabel("Select Project");



        String[] projectOptions = new String[]{};
        //create combo box


        //dynamically populate it with projects we just created
        for(int i = 0; i < taskBoardM.getProjectList().size(); i++){
            projectOptions[i] = taskBoardM.getProjectList().get(i).getProjectName();
        }


        JComboBox projectOptionsList = new JComboBox(projectOptions);

        //create Edit, Save, Delete buttons
        JButton editButton = new JButton("Edit");
        JButton saveButton = new JButton("Save");
        JButton deleteButton = new JButton("Delete");

        //adding selectProject and projectOptions to selectProjectAndComboBox
        selectProjectAndComboBox.add(selectProject);
        selectProjectAndComboBox.add(projectOptionsList);





        //adding editSaveDelete JPanel
        JPanel editSaveDelete = new JPanel();
        editSaveDelete.add(editButton);
        editSaveDelete.add(saveButton);
        editSaveDelete.add(deleteButton);


        //adding loadCreateLogout JPanel
        JPanel loadCreateLogout = new JPanel();

        //create Load, Create New and Logout buttons
        JButton loadButton = new JButton("Load...");
        JButton createButton = new JButton("Create new");
        JButton logoutButon = new JButton("logout");

        //add loLoad, Create New, and Logout buttons to the loadCreateLogout panel
        loadCreateLogout.add(loadButton);
        loadCreateLogout.add(createButton);
        loadCreateLogout.add(logoutButon);

        //add selectProjectAndComboBox and loadCreateLogout to new panel
        JPanel topBarMenu = new JPanel(new BorderLayout());
        topBarMenu.add(selectProjectAndComboBox, BorderLayout.WEST);
        topBarMenu.add(loadCreateLogout, BorderLayout.EAST);
        topBarMenu.add(editSaveDelete, BorderLayout.CENTER);


        //add topBarMenu to main JFrame
        project.add(topBarMenu, BorderLayout.NORTH);
        project.setSize(1200, 600);
        project.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        project.setBackground(Color.LIGHT_GRAY);
        project.setVisible(true);



        //add actionListener to logouButton

        logoutButon.addActionListener(e-> {
            project.dispose();
            dial.setVisible(true);

        });

    }

    public void createColumnsPanel(){
        try {

            this.columnsPanel = new JPanel();
            this.columnsPanel.setLayout(new GridLayout(0, 4));
            project.add(columnsPanel, BorderLayout.CENTER);            
            
            for(int i = 0; i < this.projectColumns.size(); i++)
            {
                Column columnMod = this.projectColumns.get(i);

                JPanel singleColumn = new JPanel();
                singleColumn.setLayout(new GridLayout(10, 0));
                
                JLabel columnsLabelTitle = new JLabel(columnMod.getName() );
                Font font = new Font("SansSerif", Font.BOLD, 20);
        		columnsLabelTitle.setFont(font);
                singleColumn.add(columnsLabelTitle);
                
                JButton addtask = new JButton("+");
                addtask.setPreferredSize(new Dimension(2, 2));
                singleColumn.add(addtask);
                
                this.columnsPanel.add(singleColumn);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

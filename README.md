# MDT
Code for Maze Design Tool

# Getting started
Create a new branch named "MDT-<Ticket_Number>_<Branch_Description>" (e.g. MDT-21_Export_mazes_dialog), pull it on your local device and commit there. Once you are happy with your branch and done with the task, create a merge request to merge with main.

# Structure
com.mdt.Program class contains the main() method that invokes the application.
com.mdt.gui.GUIFrame class is invoked by the Program.main() method and creates and shows the Frame of the application via the GUIFrame.createAndShowGUI() method.

To add a new GUI element, add it to an existing or new JPanel, add the JPanel (if not already) to the GUIFrame.createAndShowGUI() method, pack it and link all actions.

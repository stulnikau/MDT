# MDT
Code for Maze Design Tool

Maze Design Tool is an tool that allows you to design, solve, and export custom mazes.

<img width="1800" alt="Screen Shot 2022-10-20 at 8 32 40 am" src="https://user-images.githubusercontent.com/47017892/196817371-5d8a8caf-274e-43ac-a412-88b820f2d8b2.png">
<img width="1800" alt="Screen Shot 2022-10-20 at 8 33 33 am" src="https://user-images.githubusercontent.com/47017892/196817394-9537bb58-694c-4be9-938e-77b131eb13fa.png">

# Demos
Creating a maze with custom size and images inside
https://user-images.githubusercontent.com/47017892/196817981-c34e08e0-98d3-495e-a8b1-4dc4e45450b3.mp4

Building the maze manually
https://user-images.githubusercontent.com/47017892/196818572-cf724ea3-2bfe-4208-b338-02eed74c154a.mp4

Using the auto-solver and exporting the maze
https://user-images.githubusercontent.com/47017892/196818580-c536c628-2fdc-4509-b33b-5ce87be147a6.mp4

# Getting started
Create a new branch named "MDT-<Ticket_Number>_<Branch_Description>" (e.g. MDT-21_Export_mazes_dialog), pull it on your local device and commit there. Once you are happy with your branch and done with the task, create a merge request to merge with main.

# Structure
![UML2](https://user-images.githubusercontent.com/47017892/196828667-2a547701-cc57-4c8e-93c2-efa14df8ccfe.png)

com.mdt.Program class contains the main() method that invokes the application.
com.mdt.gui.GUIFrame class is invoked by the Program.main() method and creates and shows the Frame of the application via the GUIFrame.createAndShowGUI() method.

To add a new GUI element, add it to an existing or new JPanel, add the JPanel (if not already) to the GUIFrame.createAndShowGUI() method, pack it and link all actions.

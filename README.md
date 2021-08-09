#To-Do List Web Application (TDL) by Leaf Cooper

This is a Todo List Web Application constructed using a combination of Java, HTML, css and JavaScript. This project allows the user to interact via a webpage with a Todo list, with CRUD functionality

##Required software to run this application:

A web browser such as Chrome and a stable internet connection
A java IDE, Eclispe is recommended
A html/, js and css IDE, Visual Code Studio is recommended
MySQL

##Setup:

This project is split into two major elements; to view, edit and run the front end, open the files found in the front-end folder in VCS
From the html files, you can load the webpage by right clicking anywhere within the file and selecting "Open with Live Server"

The files found in the back-end folder should be loaded into Eclipse,  however some additional properties will need to be edited
In the main resources folder, open application.properties and enter details of the database to be used
This may involve creating a new database within MySQL. However no tables or structure need to be added manually

Once that is set up, right click the root folder, select Run As, then Spring Boot App.
Wait for the system to initialise, as will be visible in the console.
Once the system is initialised, the webpage can be used

##information:

The website contains the following:
A nav bar with links to the home page and a small about page
An element to view all data in the database, in this case the entire Todo list
An element to add data, in this case added a new task to the list. The task requires a name, and has options for a description and time required
An element to edit existing data, which requires the same fields as creating a task as well as the id of the data you will be updating
An element to delete data, which requires only the id of the task you plan on deleting

Each element will display a relevant output once submitted

##about:

This project was built with Maven for dependancy management, and Github for versioning

Author: Leaf Cooper

Acknowledgements:
Thank you to Jordan Benbelaid, for supervision and particuarly help recovering a data loss

*********************************************************************************************************************************************************
Hello User,Please consider the description and some specific instructions before executing the test.
--------------------------------------------------------------------------------------------------------------
Description :
*This project is related to  find Hotel Availability for the specific city to be entered and get all hotels rents for same location and then check
 the rating in descending order.
*Test Description:
       1:-Open the application https://www.trivago.in/ in chrome or fire fox browser.
       2:-In search field, enter City “Mumbai” as destination.
       3:-Select Check-In Date for the next week (e.g. 27 July)
       4:-Select Check-Out Date for the next week (e.g.28 July)
       5:-Select Adults 1 and Select Rooms 1
       6:-Click on Apply.
       7:-Click on Search.
       8:-Select Sort By “Rating only”
       9:-Get the list of Rent of the hotels displayed.
      10:-Check that the all the ratings of the hotels is in descending order (e.g. 10.0>9.8>9.6..)
      11:-Check whether the first five hotels contains the specific city searched for. Ex: Mumbai
      12:-Close the browser 
*Project Explorer Layout :
      904306_Prathamesh_Miniproject_Trivago folder
           src (source folder)
             Mini_Project (package)
               Hotel_Availability.java (Test class through it run the script)
           JRE System Library (Java system jars)
           Referenced Libraries(Selenium jars)
           TestNG(testNG jars)
           Driver(Contains necessary webdrivers)
             chromedriver.exe
             geckodriver.exe
           Input_Data(Data input folder)
             Input_data.properties(DOT properties file)
           Screenshots(Folder to save Screenshots)
           test-output(Auto system generated testNG output folder)

*Steps to execute :Please execute the Hotel_Availability.java -> Right click->Run as TestNG Test
*This project uses TestNG.

Instructions:
*Use Hotel-Availability class to execute script.
*Two webdrivers are provided (Google Chrome and FireFox) for implementation of project.In current script chromedriver is being used.To use 
another browser change the  name inside path like (chromedriver or geckodriver) and driver name like (Chrome or Firefox) in script before class method.

 
--------------------------------------------------------------------------------------------------------
******************************************************************************************************************************************************************


![Banner](docs/images/github_ug_photo.png)

# Welcome to Control Your Crowd!

Control Your Crowd (CYC) is a desktop application used for managing crowd levels at any locations or events.
Users can interact with it using a Command Line Interface (CLI).

CYC allows efficient 
tracking and accessing of visitors' profiles. Users can also easily check-in and check out a visitor, get the current 
crowd level, limit the venue capacity, save the visitor log for future references, and much more! 
CYC is an all-in-one application to help event management team, event organizers for events such as Ultra Music
Festival manage crowd level with ease. It also works very well for small enterprises and mall management team that
needs to monitor influx of visitors. 

## Quick Start

> Prerequisites:
> * Ensure that you have **Java 11** or above installed in your Computer. If you do not have, you can get it from
>   [here](https://www.oracle.com/sg/java/technologies/javase-jdk11-downloads.html).

1. Download the latest version of `CYC.jar` from [here](https://github.com/AY2021S2-CS2113T-T09-1/tp/releases).
2. Copy the file to the folder you want to use as the home folder for your CYC.
3. Open up a command window to the location where your `CYC.jar` is located.
4. Run the command `java -jar CYC.jar [VENUE_MAXIMUM_CAPACITY]`. For example, 
   `java -jar CYC.jar 500`.
   * Ensure that the `VENUE_MAXIMUM_CAPACITY` entered is a positive integer that does not exceed 6 digits.
     * You can enter input the `VENUE_MAXIMUM_CAPACITY` with or without quotations. 
       For example, `500` and `"500"` will both work.
   * When you are running the `CYC.jar` again, ensure that the `[venue maximum capacity]` is more than the current
     number of visitors checked in. Failure to do so will lead to negative maximum venue capacity.     
5. If the setup is correct, you should see CYC being loaded as shown below (note: your version of CYC would be the 
   latest version).
   
   ![QuickStart](docs/images/welcome_message.png)
   
6. Input the command in the command window and press Enter to execute it. Refer to [Features](docs/UserGuide.md#3--features)
   for details of each command.
   
> Tips and Additional Notes: 
> * Maximize the command line window to ensure that you get to make use of the visuals of CYC CLI.
> * Do **NOT** edit the `LogFile.txt`, `TrackingList.txt` or `History.txt` files.
>   * You are only allowed to copy the contents of the `History.txt` file.


Useful links:
* [GitHub Page](https://coolrainyday.github.io/Control-Your-Crowd/)
* [User Guide](docs/UserGuide.md)
* [Developer Guide](docs/DeveloperGuide.md)
* [About Us](docs/AboutUs.md)

# Two methods to try ROSE
## Method 1: Import the .ova file to a virtual machine workstation
We have already installed all the dependencies and ROSE on a virtual machine, and exported it as a .ova file.

Link: https://drive.google.com/file/d/1YODlcpmLATsOvKDtsrK7MujWJaEOzR3R/view?usp=sharing

You can download it and import into a virtual machine workstation.

After you import it successfully, enter the following commands to run Code Bubbles:
```
$ cd ~/CodeBubbles
$ java -jar bubbles.jar
``` 
And then, start from Step 4 of Method 2 to try ROSE.

## Method 2: Install on your own machine
### Dependencies
* Ubuntu: version >= 22.04
* Java:  version >= 17.0.4
* Eclipse: version >= 2022-06
### Instructions:
To try ROSE, you should follow these four steps.
* Step 1: Import demo project
* Step 2: Install Code Bubbles
* Step 3: Install ROSE
* Step 4: Run ROSE with the demo project

More detailed instructions are as follows.

### Step 1: Import demo project

* Run Eclipse.

* File -> Open Projects from File System. 

  <img src="imgs/image-01-OpenProjectsFromFileSystem.png" style="zoom:60%;" />

* Import source -> Directory.

  <img src="imgs/image-02-Directory.png" alt="image-20220827210517725" style="zoom:40%;" />

* Select "user_study" directory in this repo.

  <img src="imgs/image-03-UserStudyInThisRepo.png" alt="image-20220827210935928" style="zoom:30%;" />

* Shutdown Eclipse.

### Step 2: Install Code Bubbles

```
# install_dir is the directory where you want to install Code Bubbles and ROSE.
$ mv ./bubbles.jar ${install_dir} 
$ cd ${install_dir}  
$ java -jar bubbles.jar
```
* Select Eclipse Installation Directory.
  
  <img src="imgs/image-04-EclipseInstallationDirectory.png" alt="image-20220827210001418" style="zoom:40%;" />
  
* Select Eclipse's workspace.
  
  <img src="imgs/image-05-EclipseWorkSpace.png" alt="image-20220827210115516" style="zoom:40%;" />
  
* Other options.

  * Theme：

    <img src="imgs/image-06-Theme.png" alt="image-20220827210209418" style="zoom:60%;" />

  * User Metrics：

    <img src="imgs/image-07-UserMetrics.png" alt="image-20220827210306110" style="zoom:30%;" />

  * Bug Report：

    <img src="imgs/image-08-BugReport.png" alt="image-20220827210404172" style="zoom:30%;" />

After Select "OK" for all above options, you should see the interface of Code Bubbles. 

<img src="imgs/image-09-MainInterface.png" alt="image-20220827214624124" style="zoom:40%;" />

### Step 3: Install ROSE

* On the top of the navigation bar, select the dropdown icon -> Manage Plugins.

  <img src="imgs/image-10-ManagePlugins.png" alt="image-20220827214656022" style="zoom:80%;" />

* Select "ROSE".

  <img src="imgs/image-11-InstallROSE.png" alt="image-20220827214712373" style="zoom:80%;" />

* Select "YES".

  ![image-20220827214731467](imgs/image-12-Warnings.png)

* Restart Code Bubbles.


### Step 4: Run ROSE with the demo project
#### Step 4.1: Run the project

  *  In the `Action Button Area` in the upper right corner of the screen, click the small button on the left side of the `Debug` area.
  
     <img src="imgs/image-13-DebugPerspective.png" alt="image-20220828110735362" style="zoom:67%;" />

  * A new bubble will pop up on the screen, asking you to fill in some basic information about launching, as shown in the image below.

    <img src="imgs/image-14-Configuration.png" alt="image-20220828110735362" style="zoom:47%;" />

  * Disable the option for "Stop in Main" . And then click "Save" ->  "Debug" . Then you can switch to the debug perspective.

  * The interface of the debug perspective is shown in the figure below.

    <img src="imgs/image-15-DebugInterface.png" alt="image-20220828110755227" style="zoom:30%;" />

  * Click the `Run Button` on the left of the first line, and the demo project will be compiled and run automatically. 

  * After the compilation is finished, you will see the graphical interface be started successfully. 
    <img src="imgs/image-16-RunDemo.png" alt="image-20220828111114050" style="zoom:30%;" />

#### Step 4.2: Select "Tutorial" and Trigger the bug

  *  Select Tutorial in the graphic interface, and you should see the interface as shown below.

     <img src="imgs/image-17-Tutorial.png" alt="image-20220828111647748" style="zoom:47%;" />

  * This is a program for computing the maximum of two numbers.

  * Enter the first number : 2022,  the second number: 6.18.

  * Click "COMPUTE MAX" button. And you will see the program stopped before an assertion failed.

    To the left of the line, we will see a small red arrow -> pointing to this statement.

    And the text in this line is highlighted with a red background, as shown in the figure below.

    ![image-20220828111922958](imgs/image-18-StoppedAtAssertionFailed.png)

    This shows that ROSE has caught a failed assertion and is ready to help us.
    

#### Step 4.3: Invoke ROSE

  * Right-click the red arrow and you will see the following menu. 

    <img src="imgs/image-19-ContextMenu.png" alt="image-20220828113455491" style="zoom:30%;" />

  * Click on the first item - Ask ROSE to help debug. A bubble as shown below will appear on the screen, asking you to describe the problem you encountered.

    <img src="imgs/image-20-InvokeROSE.png" alt="image-20220828113540935" style="zoom:30%;" />

  * In the case of assertion failure, ROSE has filled the Problem box for you by default. That is, we expect ``Assertion should not have failed``.

#### Step 4.4: Suggest repairs

  * Now you can directly click ``Suggest Repairs`` to get the suggestions given by ROSE. 

  * Wait for a while and you will see the following Repair Suggestion Bubble pop up, which lists the repair suggestions that ROSE can give.

    <img src="imgs/image-21-Suggestions.png" alt="image-20220828113719925" style="zoom:50%;" />

#### Step 4.5: Preview Repairs

  * In the Repair Suggestion Bubble, each suggestion is presented in the natural language, including information such as the specific repair method, the name of the fixed function, and the repair location. 
  * ROSE may give multiple repair suggestions on one problem. It is your job to decide which of the repairs is correct (or none of them is correct) . 
  * ROSE allows you to quickly preview, compare, and try each repair suggestion. 
  * Right click on any suggestion and the pop-up menu looks like this:
    <img src="imgs/image-22-SuggestionContextMenu.png" alt="image-20220828114514452" style="zoom:67%;" />
  * You can click on the first item “Preview repair xxx" to compare the code before and after this repair. 
    As an example, the preview for the first suggestion is shown in a new bubble as the following figure.
    <img src="imgs/image-23-PreviewSuggestion.png" alt="image-20220828114647384" style="zoom:67%;" />
    The preview bubble is divided into left and right parts:
      - The left side represents the original code, and the changed characters are in green. 
      - The right side represents the changed code, and the changed characters are in red.

#### Step 4.6: Make Repair

  * After previewed a piece of suggestion, you may right click on the suggestion and then choose the second item "Make repair xxx" as shown below. 

    <img src="imgs/image-24-MakeRepir.png" alt="image-20220828120125359" style="zoom:30%;" />

  * And ROSE will automatically finish the repair in the code for you.

    ![image-20220828120138673](imgs/image-25-Repaired.png)

#### Step 4.7: Rerun the project

  * Then, click the button shown below in the `Buttons Bubbles` to  terminate the current execution.
    <img src="imgs/image-26-Terminate.png" alt="image-20220828120255679" style="zoom:60%;" />

  * To check whether the new code works, click the Run button to recompile with the new changes. After this, the repaired program will run.

    <img src="imgs/image-27-ReRun.png" alt="image-20220828120336019" style="zoom:30%;" />

  * Continue to select Tutorial in the interface, re-enter the two values in the text boxes: 2022 and 6.18. 

  * Click COMPUTE MAX, you can see the program outputs 2022.0 this time (as shown in the figure below), which is in line with our expectations.

    <img src="imgs/image-28-CorrectAnswer.png" alt="image-20220828120412666" style="zoom:47%;" />
# -home-edson-eclipse-workspace-JMONKEYENGINE-GAME-TEST
A game test using JMONKEYENGINE GAME TEST

https://jmonkeyengine.org/

jMonkeyEngine is a modern developer friendly game engine written primarily in Java.
Its minimalistic and code first approach makes it perfect for developers who want the support of a game engine while retaining full control over their code with the ability to extend and adapt the engine to their workflow.


https://wiki.jmonkeyengine.org/docs/3.4/tutorials/beginner/hello_simpleapplication.html


jMonkeyEngine 3 Tutorial (1) - Hello SimpleApplication
Prerequisites: This tutorial assumes that you have downloaded the jMonkeyEngine SDK.

In this tutorial series, we assume that you use the jMonkeyEngine SDK. As an intermediate or advanced Java developer, you will quickly see that, in general, you can develop jMonkeyEngine code in any integrated development environment (NetBeans IDE, Eclipse, IntelliJ) or even from the command line.

OK, let’s get ready to create our first jMonkeyEngine3 application.

Create a project
In the jMonkeyEngine SDK:

Choose File  New Project from the main menu.

In the New Project wizard, select the template JME3  Basic Game.

Click Next.

Specify a project name, e.g. “HelloWorldTutorial”.

Specify a path where to store your new project, e.g. a jMonkeyProjects directory in your home directory.

Click Finish.

This will create a basic jme3 application for an easy start with jme3. You can click the run button to run it: You will see a blue cube. If you have questions, read more about Project Creation here.

We recommend to go through the steps yourself, as described in the tutorials. Alternatively, you can create a project based on the JmeTests template in the jMonkeyEngine SDK. It will create a project that already contains the jme3test.helloworld samples (and many others). For example, you can use the JmeTests project to verify whether you got the solution right.

Extend SimpleApplication
For this tutorial, you need a jme3test.helloworld package in your project, with the file HelloJME3.java in it.

In the jMonkeyEngine SDK:

In the Source Packages node of your project, RMB select the “mygame” package.

Choose: Refactor  Rename

Enter the New Name: jme3test.helloworld

Click Refactor when ready.

In the newly refactored package, RMB select the Main.java class.

Choose: Refactor  Rename

Enter the New Name: HelloJME3

Click Refactor when ready.

You follow this same basic procedure for the remaining tutorials.

The remaining tutorials all use the same jme3test.helloworld package. Just refactor the “Main.java” class name to the tutorial examples class name rather than creating a new project for each.
Code Sample
Replace the contents of the HelloJME3.java file with the following code.

package jme3test.helloworld;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.math.ColorRGBA;

/** Sample 1 - how to get started with the most simple JME 3 application.
 * Display a blue 3D cube and view from all sides by
 * moving the mouse and pressing the WASD keys. */
public class HelloJME3 extends SimpleApplication {

    public static void main(String[] args){
        HelloJME3 app = new HelloJME3();
        app.start(); // start the game
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1); // create cube shape
        Geometry geom = new Geometry("Box", b);  // create cube geometry from the shape
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Blue);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube's material
        rootNode.attachChild(geom);              // make the cube appear in the scene
    }
}
RMB select the HelloJME3 class and choose Run. If a jME3 settings dialog pops up, confirm the default settings.

You should see a simple window displaying a 3D cube.

Press the W A S D keys and move the mouse to navigate around.

Look at the FPS text and object count information in the bottom left. You will use this information during development, and you will remove it for the release. (To read the numbers correctly, consider that the 14 lines of text counts as 14 objects with 914 vertices.)

Press Esc to close the application.

Congratulations! Now let’s find out how it works!

Understanding the Code
The code above has initialized the scene, and started the application.

Start the SimpleApplication
Look at the first line. Your HelloJME3.java class extends com.jme3.app.SimpleApplication.

public class HelloJME3 extends SimpleApplication {
  // your code...
}
Every JME3 game is an instance of the com.jme3.app.SimpleApplication class. The SimpleApplication class is the simplest example of an application: It manages a 3D scene graph, checks for user input, updates the game state, and automatically draws the scene to the screen. These are the core features of a game engine. You extend this simple application and customize it to create your game.

You start every JME3 game from the main() method, as every standard Java application:

Instantiate your SimpleApplication-based class

Call the application’s start() method to start the game engine.

    public static void main(String[] args){
        HelloJME3 app = new HelloJME3(); // instantiate the game
        app.start();                     // start the game!
    }
The app.start(); line opens the application window. Let’s learn how you put something into this window (the scene) next.

Understanding the Terminology
What you want to do	How you say that in JME3 terminology
You want to create a cube.

I create a Geometry with a 1x1x1 Box shape.

You want to use a blue color.

I create a Material with a blue Color property.

You want to colorize the cube blue.

I set the Material of the Box Geometry.

You want to add the cube to the scene.

I attach the Box Geometry to the rootNode.

You want the cube to appear in the center.

I create the Box at the origin = at Vector3f.ZERO.

If you are unfamiliar with the vocabulary, read more about the Scene Graph here.

Initialize the Scene
Look at rest of the code sample. The simpleInitApp() method is automatically called once at the beginning when the application starts. Every JME3 game must have this method. In the simpleInitApp() method, you load game objects before the game starts.

    public void simpleInitApp() {
       // your initialization code...
    }
The initialization code of a blue cube looks as follows:

    public void simpleInitApp() {
        Box b = new Box(1, 1, 1); // create a 1x1x1 box shape
        Geometry geom = new Geometry("Box", b);  // create a cube geometry from the box shape
        Material mat = new Material(assetManager,
          "Common/MatDefs/Misc/Unshaded.j3md");  // create a simple material
        mat.setColor("Color", ColorRGBA.Blue);   // set color of material to blue
        geom.setMaterial(mat);                   // set the cube geometry 's material
        rootNode.attachChild(geom);              // make the cube geometry appear in the scene
    }
A typical JME3 game has the following initialization process:

You initialize game objects:

You create or load objects and position them.

You make objects appear in the scene by attaching them to the rootNode.

Examples: Load player, terrain, sky, enemies, obstacles, …, and place them in their start positions.

You initialize variables:

You create variables to track the game state.

You set variables to their start values.

Examples: Set the score to 0, set health to 100%, …

You initialize keys and mouse actions:

The following input bindings are pre-configured:

W A S D keys – Move around in the scene

Mouse movement and arrow keys – Turn the camera

Esc key – Quit the game

Define your own additional keys and mouse click actions.

Examples: Click to shoot, press Space to jump, …

The Future of SimpleApplication
There are plans to change SimpleApplication. Sometime back it was decided that we should really re-factor the Application class. SimpleApplication especially is a mess of “magic” protected fields that on the one hand makes it really easy to slam some simple one-class application together, but on the other hand does new users no favors because they have no idea where 'cam' and 'assetManager' come from. Unfortunately, lots of code refers to Application and it’s tough to change…​ especially the app states.

So, we hatched a plan to convert the Application class to an interface. This would give us some freedom to iterate on a new set of application base classes. You can read about the changes here. As said before we are envisioning a better design that is not enforced today, but that is already usable.

If you look at SimpleApplication default constructor you will understand how it works.

public SimpleApplication() {
    this(new StatsAppState(), new FlyCamAppState(), new AudioListenerState(), new DebugKeysAppState());}
Basically the application is injected upon construction with the default AppStates. Let’s look at the second constructor.

public SimpleApplication( AppState... initialStates ) {
    super(initialStates);
}
It allows you to specify what AppState you want for your application. So SimpleApplication is handy for test projects (I very often use it as is) but I recommend for a full blown-game to use it like this:

public class MyGame extends SimpleApplication {

    public MyGame(){
         super(new MyCustomState(), new AnotherState(), ....);
    }

    public static void main(String[] args) {
        MyGame app = new MyGame();
        app.start();
    }

}
Then have all logic implemented in AppStates and your SimpleApplication will never change much, except when you want to add a bootstrap AppState (or maybe you can have an AppState that manages AppStates…​), SimpleApplication is just the list of states you are using.

In future versions, all the code in SimpleApplication will be refactored in AppStates (InputHandlingState, RenderAppState, whatever) and you will decide what you want to use. However, for legacy sake we kept the code as is for now.

If you follow this recommendation, when the changes are finalized, you will only need to do a few things different from now to make your old apps work and to create new ones.

Extend BaseApplication rather than SimpleApplication when creating new apps.

Update your existing apps by changing SimpleApplication to BaseApplication in your main class.

Change any references you have made to SimpleApplication’s protected fields.

For example, rather than turning off the FlyCam() like so,

flyCam.setEnabled(false);
You would just leave the statement new FlyCamAppState() out of the constructor instead.

SimpleApplication will be around for some time as it will take time for people to migrate to BaseApplication, but AppStates make life easier anyway so you may as well start using them.

Conclusion
You have learned that a SimpleApplication is a good starting point because it provides you with:

A simpleInitApp() method where you create objects.

A rootNode where you attach objects to make them appear in the scene.

Useful default input settings that you can use for navigation in the scene.

When developing a game application, you want to:

Initialize the game scene

Trigger game actions

Respond to user input.


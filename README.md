Jazz
====

The game itself

Controls:
=========

Move mouse to move up or down.
Left click Pulls.
Right click pushes.

Proccess to pull:
=================

There may be a better way to do this but its what worked for me.
Install the adroid sdk before anything. Also install the adt plugin for eclipse.
I would install the gradle plugin for eclipse. This requires the springboard plugin too or something.
In addition I would reccomend installing the git plugin for eclipse.
Then I would clone this repo using regular git, then import it into eclipse using the gradle plugin. 
(file->import->gradle)
If you are getting an error about android sdk path, craete a file called local.properties at the root fo the directory and put the line sdk.dir-(whereever your android sdk is). 
It should automagically recognize it is from git and mark it as such. When you commit it does it fo all projects.
You should be good to go now.




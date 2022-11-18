# My Personal Project

## Creating A Training Log Application for Triathletes


### What Does This Application Do?
This application helps triathletes (or any manner of endurance
athlete) to keep track of their workouts and training loads. It is able
to record several types of information that would be useful in analyzing
performance over time and allows an athlete to look back on their past
data. At the moment, this application supports recording swim, bike, and run workouts.

Some examples of the data this application can record (with some of the
most commonly used types in **bold**):
- **Average heart rate**
- **Pace** (for running and swimming workouts) (in seconds, either implied to be per 1km or 100m depending on
the workout title of running or swimming)
- **Average Speed** (for cycling workouts)
- Time (in minutes)
- Perceived Difficulty (on a scale of 1-10)
- Distance (in km)
- Training Load (minutes * perceived difficulty)

All of this data will be in an integer format. Each workout can also have a type and a date, both in 
string format. Each workout will be stored in a training log so that it can be viewed at a later date. 
I recommend you create a new list of workouts (training log) for each new week, titling them with the dates 
the list spans. 

### My Interest In This Project
I am a triathlete myself who has used multiple different platforms and software to record and track my training. 
Creating my own version of such an application is both an engaging and interesting opportunity to look at the 
thought process behind building something I use every day. 

### User Stories

- As a user, I want to be able to add new workouts to a training log (a list
of workouts).
- As a user, I want to be able to create a new training log add workouts to it.
- As a user, I want to be able to change my workout title, date or distance after inputting it.
- As a user, I want to be able to view the workouts in my training log. 
- As a user, I want to be able to see how many workouts with a certain title my training log contains.
  (i.e. how many workouts titled "Running" are contained in my current training log)
- As a user, I want to be able to save my training log to file.
- As a user, I want to be able to reload my saved training log with all data intact and continue to add workouts to it. 

# Instructions for Grader

- You can generate the first required event related to adding Xs to a Y by running the Main class and clicking on 
either the button for adding a swim, adding a bike, or adding a run. You can do this multiple times to add any of these
three kinds of workouts both to the display area and an internal Training Log that keeps track of each one. 
- You can generate the second required event related to adding Xs to a Y by adding at least one workout and clicking 
the Filter By Type button. For the best demonstration of this functionality, add at least two workouts of different 
types before clicking the FilterByType button. 
- You can locate my visual component by 
- You can save the state of my application by clicking the Save Current Training Log button.  
- You can reload the state of my application by clicking the Load Previous Training Log button. 

 
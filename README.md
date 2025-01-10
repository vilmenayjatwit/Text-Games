# Text-Games
Roles and Tasks:

Area 1 (Prep Station):
- Checks if user selects the right ingredients 
- Could be multiple choice
	- ex: A) Flower, Sugar B) Tomato, Cheese
	- If user picks correctly they'll go to the next Area 

Area 2 (Tools):
- Same as area 1 except with tools
- Could be Frying pan, mixer, etc

Area 3 (Cooking):
- Same as 1&2, if the user cooks correctly they pass

Area 4 (Serving): 
- Tell the user to serve the dish (yes/no or 1/2 idk)
- Returns a value to the main class so that it can move on to next dish
	- ex:
	Check:
	If correct → Return sum indicating success (return "5") so the main game can start the next dish.
	If incorrect → Stay here (return 4) 

Main Method (Cooking Mama):
- Welcome the player/intro
- Create the dish loop
- Check if all the dishes are done
- End the game
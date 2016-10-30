# EscapeTheDungeon

Simple and short text-based adventure game.

cs141


## Credits / Author(s)

James Taracevicz


## Description 

Begin by selecting your gun (pistol, rifle, or shotgun), and (optionally) enabling auto-take-step mode
(proceeds in game Player to next tile when not faced with an Enemy).

Reach and clear the 10th tile in a linear dungeon starting at tile 0 fighting enemies at random points.

Each Enemy will wield one of the same guns available to the player (randomly selected), and they'll drop a 
medkit or ammo pack which the Player automatically uses.


## Solving this Assignment

1. Read the description to understand how the game will play out.
2. Break down components of the game to be categorized into classes with shared methods & attributes located in 
abstract super classes or interfaces.
3. Begin to build each class adding attributes and methods to each until a runnable game with minimal features
is built.
4. Continue adding features (updating & adding to classes) and fixing bugs until the assignment 
is fully completed.
5. After the completion of the assignment I chose to use enumerator classes to use to define constant Strings
that needed to be accessed throughout several classes;


## Conclusions and Lessons Learned

* Class inheritance can be critical for avoiding writing the same code twice.
* Classes are pivotal for encapsulating code keeping methods and attributes contained with the object.
* Strings are objects and using the `==` operator is ineffective when comparing the values of two string (use
`Object.equals(Object)` method).

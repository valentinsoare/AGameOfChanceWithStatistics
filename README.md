# :four_leaf_clover: A Game of Chance - Craps

:arrow_forward: Interactive Game of Craps made in **Java 17** that can be run in CLI with main and secondary menu 
and can take input from user and act on it after it was validated. In case something is wrong an appropriate error
will be printed.

:arrow_forward: We can register, remove, select a player, print help, print statistics, print players  
and play only one game of craps or play multiple games set by the player.

:arrow_forward: Games that are played are register in history and stats are calculated from the counters saved into storage arrays.

[![final-Small.png](https://i.postimg.cc/DfLpz7ky/final-Small.png)](https://moviesondemand.io)

## Concepts/technologies used:
1. [X] Object-Oriented Programming Principles;
2. [X] Collections Framework - ArraysList, LinkedList, HashMap and Set
3. [X] Recursion;
4. [X] Comparator and Iterator;
5. [X] Lambda functions, Streams and Method references;
6. [X] Third party libraries - Apache Commons Lang and Lombok;

<br>

> [!NOTE]
> Project is :100: delivered!

<br>

## Output from the game...

:white_check_mark: Here is the loading effect (progress bar) when starting the application.

```
             Loading The Game Of Craps 

     [################################### 89%     ]
```

<br>

:white_check_mark: Main menu after the loading bar completed and there is no registered player.

```
  -------------------------------
   # Playing The Game Of Craps # 
  -------------------------------

  [ 1 ] Games To Be Played 
  [ 2 ] Play One Game 
  [ 3 ] Print Statistics 
  [ 4 ] Register Player 
  [ 5 ] Change Player 
  [ 6 ] Reset Games Statistics 
  [ 7 ] Print Players 
  [ 8 ] Help 
  [ 9 ] Quit 

  player: None
  -------------------------------
  provide an option: 
```

<br>

:white_check_mark: Register a player.

```
  -------------------------------
   # Playing The Game Of Craps # 
  -------------------------------
           Add Player

  In order to add a player please provide complete name, age, occupation separated by a comma.

  player: None
  -------------------------------
  provide the necessary information to register a player or (quit/back): 
```

<br>

:white_check_mark: Set/Change a player after it is registered. You can have multiple registered players.

```
  -------------------------------
   # Playing The Game Of Craps # 
  -------------------------------
          Change Player

  [ 1 ] Valentin, Age: 35, Occupation: engineer
  [ 2 ] Back
  [ 3 ] Quit

  player: None
  -------------------------------
  please choose a player from above or back/quit option: 
```

<br>

:white_check_mark: Set the numbers of games to be played and the loading effect with dots when setting the parameter.

```
  -------------------------------
   * Playing The Game Of Craps * 
  -------------------------------
        Games To Be Played

  Please you need to tell us how many games you want to be played. Statistics will be calculated. 

  player: Valentin
  -------------------------------
  provide requested information or back/quit: 50

  50 games were selected to be played.......DONE
```

<br>

:white_check_mark: Printing statistics for those 50 games played.

```
-------------------------------
   * Playing The Game Of Craps * 
  -------------------------------
    Playing 50 Games Of Craps

  The Games Are Running..........DONE

  Number of Wins per roll and chances for them: 

  Rolls     Wins      Chances   
  |   1  |       8  |   16.0% 
  |   2  |       7  |   14.0% 
  |   3  |       2  |    4.0% 
  |   4  |       0  |    0.0% 
  |   5  |       1  |    2.0% 
  |   6  |       0  |    0.0% 
  |   7  |       1  |    2.0% 
  |   8  |       1  |    2.0% 
  |   9  |       1  |    2.0% 
  |  10  |       1  |    2.0% 
  |  11  |       1  |    2.0% 
  |  12  |       0  |    0.0% 
  |  13  |       0  |    0.0% 
  |  14  |       0  |    0.0% 
  |  15  |       1  |    2.0% 

  -------------------------------

  Number of Losses per roll and chances for them: 

  Rolls     Losses    Chances   
  |   1  |       5  |   10.0% 
  |   2  |       5  |   10.0% 
  |   3  |       4  |    8.0% 
  |   4  |       3  |    6.0% 
  |   5  |       1  |    2.0% 
  |   6  |       2  |    4.0% 
  |   7  |       2  |    4.0% 
  |   8  |       1  |    2.0% 
  |   9  |       1  |    2.0% 
  |  10  |       1  |    2.0% 
  |  11  |       1  |    2.0% 

  -------------------------------

      Games Played /      Wins /    Losses / Chances For Winning / For Loosing
  1.            50        24.0        26.0                  48.0          52.0

  -------------------------------

      Games Played / Average length
    1.          50              3.0

  -------------------------------
```

<br>

:white_check_mark: Choose what to do after stats are printed.
```
  -------------------------------
   * Playing The Game Of Craps * 
  -------------------------------
           What To Do ?

  [ 1 ] Play Again 
  [ 2 ] Return To How Many Games To Play 
  [ 3 ] Back To Main Menu 
  [ 4 ] Quit 

  player: Valentin
  -------------------------------
  please choose an option from above: 
```

:point_right: You can check the rest of the functionalities if you clone this repo and try it.

<br>

<br>

:arrow_forward: Class dependencies until now -> 

[![class_dependencies](https://i.postimg.cc/4NJdztNN/Screenshot-from-2023-12-13-02-12-24.png)](moviesondemand.io)

<br>

_Statistics_

[![HitCount](https://hits.dwyl.com/valentinsoare//AGameOfChanceWithStatistics.svg?style=flat-square&show=unique)](http://hits.dwyl.com/valentinsoare//AGameOfChanceWithStatistics)

_Social buttons_

[![valentinsoare - AGameOfChanceWithStatistics](https://img.shields.io/static/v1?label=valentinsoare&message=AGameOfChanceWithStatistics&color=green&logo=github)](https://github.com/valentinsoare/AGameOfChanceWithStatistics "Go to GitHub repo")
[![stars - AGameOfChanceWithStatistics](https://img.shields.io/github/stars/valentinsoare/AGameOfChanceWithStatistics?style=social)](https://github.com/valentinsoare/AGameOfChanceWithStatistics)
[![forks - AGameOfChanceWithStatistics](https://img.shields.io/github/forks/valentinsoare/AGameOfChanceWithStatistics?style=social)](https://github.com/valentinsoare/AGameOfChanceWithStatistics)

_Repo metadata_

[![GitHub tag](https://img.shields.io/github/tag/valentinsoare/AGameOfChanceWithStatistics?include_prereleases=&sort=semver&color=green)](https://github.com/valentinsoare/AGameOfChanceWithStatistics/releases/)
[![License](https://img.shields.io/badge/License-Apache-green)](#license)
[![issues - AGameOfChanceWithStatistics](https://img.shields.io/github/issues/valentinsoare/AGameOfChanceWithStatistics)](https://github.com/valentinsoare/AGameOfChanceWithStatistics/issues)


## License

Released under [MIT](/LICENSE) by [@valentinsoare](https://github.com/valentinsoare)
:mailbox: [Contact me](soarevalentinn@gmail.com "Contact me at soarevalentinn@gmail.com")

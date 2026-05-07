# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Testing for player names - Invalid
Testing if not entering a name works

### Test Data To Use

I will enter an Invalid/Blank value
### Expected Test Result
It is not going to let me enter a blank name

---

## Moving the counters
testing moving the counters e.g. from 8 - 7

### Test Data To Use

i will input valid data eg 8 then 7
### Expected Test Result

it will swap the counters position

---
## Game win

A player will win the game
### Test Data To Use

the player will remove the counter in space 1, "r" is the valid data
### Expected Test Result

it should end the game and tell the player they win

---

## Remove the counter in the first place

I will remove the white counter in the first space
### Test Data To Use

I will input "r" expected 
### Expected Test Result

It will remove the counter in the first place

---

## Game setup

The game will start up

### Test Data To Use

i will run the code
### Expected Test Result

It will have 5 counters on the board

---
## Swapping between players

At the end of their turn it will swap to the other player
### Test Data To Use

I will input an expected valid input
### Expected Test Result

It will swap successfully 

---
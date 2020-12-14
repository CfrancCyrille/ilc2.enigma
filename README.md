# TP 4A ILC 2020-21: enigma
Code for the German Enigma machine used in WW2.

## Questions
1. Fork this github repository  (2 points)
2. Run the project
3. Comment the 3 classes (3 points)
4. Commit your changes and check-it into github
5. On github, make a pull request (1 point)
6. Complete the next section : "Functions to be tested" into this file (2 points)
7. Commit your changes (commit README.md)
8. On github, update your pull request (1 point)
9. Make tests (call your test functions using the rule: GIVEN_WHEN_THEN) (10 points)
10. Commit your changes
11. On github, update your pull request (1 point)
12. that ends

## Functions to be tested
Hereafter, for each classes give function to be tested. Remember that all functions does not have to be tested, some code can be checked by a simple inspection or an analyse, another code can be validated by definition (rules, etc) the others function can be tecsted by unit tests, integration tests or validation tests (IADT: Inspect, Analyse, Define, Test). 

### Classe Machine

| Function      |     I A D T     |        Comment |
| :------------ | :-------------: | :------------- |
| setPositions  | T |  |
| advanceRotors | T |  |
| convertChar   | I |  |
| configure  | D | initialise the class |
| convert  | I |  |
| initRotors  | A | initialise attributes |


### Classe Reflector

| Function      |     I A D T     |        Comment |
| :------------ | :-------------: | :------------- |
| reflectorFactory  | A |  |
| Reflector  | A | constructor |
| convertForward  | T |  |
| convertBackward  | T |  |
| advance  |  | Not implemented  |


### Classe Rotor

| Function      |     I A D T     |        Comment |
| :------------ | :-------------: | :------------- |
| convertForward  | T |  |
| getPosition  | D | Getter |
| setPosition  | D | Setter |
| rotorFactory  | A |  |
| Rotor  | A | Constructor |
| convertBackward  | T |  |
| advance  | I |  |
| atNotch  | I |  |
| toLetter  | D | Simple cast |
| toIndex  | D | Simple cast  |
| createBCipher | I |  |




## Test some functions

### Classe Machine
#### functions

public void setPositions(String setting)

void advanceRotors()

### Classe Reflector
#### functions

public int convertForward(int p)

public int convertBackward(int e)

### Classe Rotor
#### functions

public int convertForward(int p)

public int convertBackward(int e)

## Tricks & tips

- Start with simple classes (models, libraries, etc) at the end make test into complex classes (classes with multiple relations)
- Never test auto generate code
- Never test creator (its a design problem)
- Use @Test before each testFunction !
- When you test a void function of the class Rotor, then test the rotor instance's state
```Java
Rotor r=new Rotor();
int actual = r.getosition();
```
- You can test a function than throws an exception with the argument: expected
```Java
@Test(expected=Exception.class)
```
## Documentation and validation set
### How simulate Enigma machine:
- https://korben.info/enigma-le-simulateur.html
### Configuration code :
- \* B III IV I AXLE
- FROM his shoulder Hiawatha / HYIHL BKOML IUYDC MPPSF SZW
- Took the camera of rosewood / SQCNJ EXNUO JYRZE KTCNB DGU



 

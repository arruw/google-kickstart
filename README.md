# Google Kick Start
https://codingcompetitions.withgoogle.com/kickstart

This repository contain Visual Studio Code development environemnt for Java.
All dependencies are packed in a Docker image.

1. Clone and open this repository in remote container: `> Remote-Containers: Reopen in Container`
2. Bootstrap workspace for a new challange: `> Tasks: Run Task > bootstrap > [year] > [round] > [challange_name]`
3. Copy/paste example input and output from the challange web page to the `.stdin` and `.stdout` files
4. Solve the coding challange in the `Solution.java` file
5. To use Java debugger focus `Solution.java` file and click `F5`
6. To test your solution focus `Solution.java` file and then `> Tasks: Run Test Task`
7. To submit your solution just copy `Solution.java` file to the submition box on the web page.

## Solved Challanges

![Google Kick Start Badge](https://google-kickstart-me.herokuapp.com/flier/matjazmav/java/thumbnail)

### 2018

#### Round A
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [even_digits]         | ✔️         | ✔️        |

[even_digits]: rounds/2018/a/even_digits

### 2019

#### Round A
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [training]            | ✔️         | ✔️        |

[training]: rounds/2019/a/training

### 2020

#### Round A
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [allocation]          | ✔️         | ✔️        |

[allocation]: rounds/2020/a/allocation

#### Round D
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [record_breaker]      | ✔️         | ✔️        |
| [alien_piano]         | ✔️         | ✔️        |

[record_breaker]: rounds/2020/d/record_breaker
[alien_piano]: rounds/2020/d/alien_piano

#### Round F
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [atm_queue]           | ✔️         | ✔️        |

[atm_queue]: rounds/2020/f/atm_queue

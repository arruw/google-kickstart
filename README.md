# Google Kick Start

![Solutions](https://github.com/matjazmav/google-kickstart/workflows/Solutions/badge.svg)

This repository contain some solutions of the [Google Kick Start](https://codingcompetitions.withgoogle.com/kickstart) challanges and Visual Studio Code development environemnt for Java with all dependencies packed in a Docker image.

See more here:
* [Solved Challanges](#solved-challanges)
* [How to use this repository](#how-to-use-this-repository)

[
  ![Google Kick Start Badge](https://google-kickstart-me.herokuapp.com/flier/matjazmav/java/thumbnail)
](https://github.com/matjazmav/google-kickstart-me)

Get your Kick Start badge here: [matjazmav/google-kickstart-me](https://github.com/matjazmav/google-kickstart-me)

## Solved Challanges

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

#### Round E
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [high_buildings]      | ✔️         | ✔️        |

[high_buildings]: rounds/2020/e/high_buildings

#### Round F
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [atm_queue]           | ✔️         | ✔️        |
| [metal_harvest]       | ✔️         | ✔️        |

[atm_queue]: rounds/2020/f/atm_queue
[metal_harvest]: rounds/2020/f/metal_harvest


#### Round G
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [kick_start]          | ✔️         | ✔️        |
| [maximum_coins]       | ✔️         | ✔️        |
| [combination_lock]    | ✔️         | ❗TLE       |

[kick_start]: rounds/2020/g/kick_start
[maximum_coins]: rounds/2020/g/maximum_coins
[combination_lock]: rounds/2020/g/combination_lock


#### Round H
| Solution              | Test set 1 | Test set 2 |
|-----------------------|------------|------------|
| [retype]              | ✔️         | ✔️        |
| [boring_numbers]      | ✔️         | ❗TLE       |

[retype]: rounds/2020/h/retype
[boring_numbers]: rounds/2020/h/boring_numbers

## How to use this repository

### Requirements
* Git
* Docker
* Visual Studio Code with Remote-Containers extension

### Steps
1. Clone and open this repository in remote container: `> Remote-Containers: Reopen in Container`
2. Bootstrap workspace for a new challange: `> Tasks: Run Task > bootstrap > [year] > [round] > [challange_name]`
3. Copy/paste example input and output from the challange web page to the `.stdin` and `.stdout` files
4. Solve the coding challange in the `Solution.java` file
5. To use Java debugger focus `Solution.java` file and click `F5`
6. To test your solution focus `Solution.java` file and then `> Tasks: Run Test Task`
7. To submit your solution just copy `Solution.java` file to the submition box on the web page.

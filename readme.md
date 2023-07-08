# Project eCourse
## 1. Description of the Project

               _____                          
              / ____|                         
          ___| |     ___  _   _ _ __ ___  ___ 
         / _ \ |    / _ \| | | | '__/ __|/ _ \
        |  __/ |___| (_) | |_| | |  \__ \  __/
         \___|\_____\___/ \__,_|_|  |___/\___|

Laboratório de Projeto (SEM4_PI)

Polythecnic of Porto, School of Engineering

>* Diogo Magalhães (1210972@isep.ipp.pt)
>* Gabriel Silva (1210808@isep.ipp.pt)
>* Ricardo Peixoto(1210973@isep.ipp.pt)
>* Ricardo Venâncio (1210828@isep.ipp.pt)
>* Vicente Teixeira (1210974@isep.ipp.pt)

---------------------------------------------

This application is part of the lab project for the course unit EAPLI. 
Parts of the application were developed to show specific approaches or techniques.
In the Sprint A, we implemented the technical documentation and user authentication features of the project.

## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

Make sure Maven is installed and on the PATH.

The java source is Java 1.8+ so any JDK 1.8 or later will work. However, in order to generate the javadoc and UML diagrams the JDK version must be *strictly 1.8*.

If using an Oracle database, you will need to change your maven settings for 
downloading the Oracle drivers. see <https://blogs.oracle.com/dev2dev/entry/how_to_get_oracle_jdbc#settings> for more information.

run script 

    rebuild-all.bat

## 4. How to Execute Tests

There are no user stories which need tests in this Sprint A.

## 5.1 How to Run
Windows:
Make sure a JRE is installed and on the PATH

run script 

    run-backoffice 

or 

    run-user.bat

Linux:
Make sure a JRE is installed and on the PATH

run script

    run-user.bat

or

    run-user.sh

## 5.2 How to Run Bootstrap

Windows:
Make sure a JRE is installed and on the PATH

run script

    run-backoffice 

or

    run-bootstrap.bat

Linux:
Make sure a JRE is installed and on the PATH

run script

    run-bootstrap.bat

or

    run-bootstrap.sh

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

*To Do*

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh
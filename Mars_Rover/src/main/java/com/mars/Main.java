package com.mars;

import java.util.Scanner;

/*
* Main Class of the application
* Output : New Positions Of the Rovers
* */

public class Main {

    public static void main(String[] args){


        System.out.println("Insert the coordinates of the plateau");
        Scanner in = new Scanner(System.in);
        String plateauDimentions = in.nextLine();

        System.out.println("Insert first rover position");
        String firstRoverPosition = in.nextLine();

        System.out.println("Insert first rover instructions");
        String firstRoverInstructions = in.nextLine();

        System.out.println("Insert second rover position");
        String secondRoverPosition = in.nextLine();

        System.out.println("Insert second rover instructions");
        String secondRoverInstructions = in.nextLine();
        in.close();

        RoverPosition rovverPosition = new RoverPosition();
        String out = rovverPosition.finalPositionAndDirectionOfRovers(plateauDimentions, firstRoverPosition, firstRoverInstructions, secondRoverPosition, secondRoverInstructions);
        System.out.println("Rovers new postions are ");
        System.out.println(out);
    }

}

package com.mars;

public class RoverPosition {

    RoverAction roverAction = new RoverAction();

    /*
    * return final position and Direction of Rovers
    * */
    public String finalPositionAndDirectionOfRovers(String plateuDimentionsInput, String rover1Position, String rover1Instructions, String rover2Position, String rover2Instructions) {
        roverAction.checkIfInputsAreNotEmptyOrNegative(plateuDimentionsInput, rover1Position, rover1Instructions);
        roverAction.checkIfInputsAreNotEmptyOrNegative(plateuDimentionsInput, rover2Position, rover2Instructions);

        roverAction.authenticateRoversStartPosition(rover1Position, rover2Position);
        roverAction.authenticatePositionOfRoverIsOutsidePlateu(plateuDimentionsInput, rover1Position);
        roverAction.authenticatePositionOfRoverIsOutsidePlateu(plateuDimentionsInput, rover2Position);

        String finalPosition1 = roverAction.roverPositionAndDirection(plateuDimentionsInput, rover1Position, rover1Instructions);
        String finalPosition2 = roverAction.roverPositionAndDirection(plateuDimentionsInput, rover2Position, rover2Instructions);
        String finalPositionRover1Rover2="Rover 1 : "+ finalPosition1 + "\n" + "Rover 2 : " + finalPosition2;

        roverAction.authenticatePositionOfRoverIsOutsidePlateu(plateuDimentionsInput, finalPosition1);
        roverAction.authenticatePositionOfRoverIsOutsidePlateu(plateuDimentionsInput, finalPosition2);
        roverAction.authenticateRoverDirection(rover1Position);
        roverAction.authenticateRoverDirection(rover2Position);
        roverAction.authenticateRoversPosition( finalPosition1, finalPosition2,rover2Position,rover1Position);

        return finalPositionRover1Rover2;
    }
}

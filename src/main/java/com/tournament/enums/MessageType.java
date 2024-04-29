package com.tournament.enums;

public enum MessageType {

    PREROUND("Your opponent is %s"),
    ROUND_START("Round %s has started"),
    FINAL("We are in the final!"),
    SEMI_FINAL("We are in the semi-finals!"),
    QUARTER_FINAL("We are in the quarter-finals!"),
    WINNER("You are the winner!"),
    FIGHTING_RESULT("%s has won against %s"),
    FIGHT_SCORE("%s: %s - %s: %s");

    private String message;
    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public MessageType format(Object... args) {
        this.message = String.format(message, args);
        return this;
    }

}

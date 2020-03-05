package com.vinnik.kate;

import java.util.Hashtable;
import java.util.Random;

public class TaskTable {
    private final static int BOTTOM_BOUND_OF_RANDOM = 10000;
    private final static int UPPER_BOUND_OF_RANDOM = 100000;
    private int lastTaskIdentifier;

    private final Hashtable<Integer, Task> taskTable;

    public TaskTable(int amountOfMeasurements) {
        this.lastTaskIdentifier = 0;
        this.taskTable = this.fillTableWithTasks(amountOfMeasurements);
    }

    public Task getLastTaskIdentifier() {
        return taskTable.get(lastTaskIdentifier);
    }

    public boolean setLastTaskIdentifier(int identifierOfNewTakenTask) {
        if (identifierOfNewTakenTask < taskTable.size()) {
            this.lastTaskIdentifier = identifierOfNewTakenTask;
            System.out.print("Last task is now " + this.lastTaskIdentifier);
            return true;
        }
        return false;
    }

    public int getSize() {
        return taskTable.size();
    }

    private Hashtable<Integer, Task> fillTableWithTasks(int amountOfMeasurements) {
        final Hashtable<Integer, Task> tableWithTasks = new Hashtable<>();
        for (int i = 0; i < amountOfMeasurements; i++) {
            tableWithTasks.put(i, new Task(i, this.generateRandom()));
        }
        return tableWithTasks;
    }

    private int generateRandom() {
        final Random random = new Random();
        return (BOTTOM_BOUND_OF_RANDOM + random.nextInt(UPPER_BOUND_OF_RANDOM));
    }

    public void printFilledTable() {
        for (int i = 0; i < this.taskTable.size(); i++) {
            System.out.println(this.taskTable.get(i).getTaskIdentifier() + " " + this.taskTable.get(i).getAmountOfNumbers());
        }
    }
}

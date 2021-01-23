package com.ithilel.menu.base;

import java.util.Scanner;

public class Menu {
    private MenuItem[] item;
    private Scanner sc;

    public Menu(MenuItem[] item, Scanner sc) {
        this.item = item;
        this.sc = sc;
    }

    public void run() {
        while (true) {
            showMenu();
            int choice = getUserChoice();
            if (isChoiceValid(choice)) {
                System.out.println("invalid choice,try again");
                continue;
            }
            item[choice].exec();
            if (item[choice].closeAfter()) break;
        }
    }

    private boolean isChoiceValid(int choice) {
        return choice < 0 || choice >= item.length;
    }

    private int getUserChoice() {
        int choice = 0;
        System.out.println("Enter number of you choice");
        if (sc.hasNextInt()) choice = sc.nextInt();
        sc.nextLine();
        return choice - 1;
    }

    private void showMenu() {
        for (int i = 0; i < item.length; i++) {
            System.out.println(i + 1 + " " + item[i].getName());
        }
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dkatalis.atm;

import com.mycompany.dkatalis.atm.models.Auth;
import com.mycompany.dkatalis.atm.models.Transaction;
import com.mycompany.dkatalis.atm.validators.DepositValidator;
import com.mycompany.dkatalis.atm.validators.LoginValidator;
import com.mycompany.dkatalis.atm.validators.TransferValidator;
import com.mycompany.dkatalis.atm.validators.WithdrawValidator;
import com.mycompany.dkatalis.atm.validators.iValidator;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author abdulsalam
 */
public class Bootstrap {

    public static void boot(
            iValidator validator,
            Transaction... args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            print(false, "input:");
            String input = scanner.nextLine();
            String parts[] = input.split(" ");

            if (!parts[0].equalsIgnoreCase("login") && !validator.validate(parts, args[0])) {
                continue;
            }

            switch (parts[0]) {
                case "login" -> Auth.setLogin(parts[1]);
                case "deposit" -> args[0].transaction(Double.parseDouble(parts[1]));
                case "withdraw" -> args[1].transaction(Double.parseDouble(parts[1]));
                case "transfer" -> args[2].transaction(Double.parseDouble(parts[2]), parts[1]);
                case "history" -> Bootstrap.print(true, args[0].getHistory());
                case "balance" -> Bootstrap.print(true, args[0].getCurrentBalance());
                case "logout" -> {
                    Auth.setLogout();
                    Bootstrap.prepareMachineWords();
                }
                default -> {
                    break;
                }
            }
            
            if (Auth.isLoggedIn()) {
                Bootstrap.print(true, "Current balance: " + args[0].getCurrentBalance());
            }
        }
    }

    public static iValidator prepare() {
        iValidator loginValidator = new LoginValidator();
        iValidator depositValidator = new DepositValidator();
        iValidator withdrawValidator = new WithdrawValidator();
        iValidator transferValidator = new TransferValidator();

        loginValidator.setNext(depositValidator);
        depositValidator.setNext(withdrawValidator);
        withdrawValidator.setNext(transferValidator);

        return loginValidator;
    }

    public static void print(boolean newLine, Object... args) {
        if (newLine) {
            System.out.println(Arrays.toString(args));
        } else {
            System.out.print(Arrays.deepToString(args));
        }
    }

    public static void prepareMachineWords() {
        print(true, "=================");
        print(true, "DKATALIS ATM");
        print(true, "=================");

        print(true, "login: use keyword `login <username>`");
        print(true, "deposit: use keyword `deposit <amount>`");
        print(true, "withdraw: use keyword `withdraw <amount>`");
        print(true, "transfer: use keyword `transfer <target> <amount>`");
        print(true, "list history: use keyword `history`");
        print(true, "get current balance: use keyword `balance`");
        print(true, "logout: use keyword `logout`");
    }
}

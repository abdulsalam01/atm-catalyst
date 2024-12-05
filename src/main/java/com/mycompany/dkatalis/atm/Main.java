/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dkatalis.atm;

import com.mycompany.dkatalis.atm.models.Auth;
import com.mycompany.dkatalis.atm.models.Transaction;
import com.mycompany.dkatalis.atm.models.DepositTransaction;
import com.mycompany.dkatalis.atm.models.TransferTransaction;
import com.mycompany.dkatalis.atm.models.WithdrawTransaction;
import com.mycompany.dkatalis.atm.validators.iValidator;

/**
 *
 * @author abdulsalam
 */
public class Main {

    public static void main(String[] args) throws Exception {
        iValidator validator = Bootstrap.prepare();
        Transaction depositWrapper = new DepositTransaction();
        Transaction withdrawWrapper = new WithdrawTransaction();
        Transaction transferWrapper = new TransferTransaction();

        Bootstrap.prepareMachineWords();
        Bootstrap.boot(validator,
                depositWrapper, withdrawWrapper, transferWrapper);
    }
}

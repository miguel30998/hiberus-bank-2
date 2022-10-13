package com.hiberus.worker.Service;

public interface BalanceService {

    boolean uploadBalance(String dni, float money,boolean method );

    float getBalanceWorker(String dni);

    boolean setBalanceWorker(String dni, float money);

    
}

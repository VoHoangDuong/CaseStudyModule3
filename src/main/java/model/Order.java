package model;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private Account account;
    private List<Item> productLis;
    private int status;

    public Order() {
        this.status = 0;
    }

    public Order(int id, Account account, List<Item> productLis, int status) {
        this.id = id;
        this.account = account;
        this.productLis = productLis;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Item> getProductLis() {
        return productLis;
    }

    public void setProductLis(List<Item> productLis) {
        this.productLis = productLis;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

package online.portowyi.eventlog.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    private String transactionID;
    private boolean transactionCommit;
    private LocalDateTime transactionOpenDate;
    private LocalDateTime transactionCommitDate;

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public boolean isTransactionCommit() {
        return transactionCommit;
    }

    public void setTransactionCommit(boolean transactionCommit) {
        this.transactionCommit = transactionCommit;
    }

    public LocalDateTime getTransactionOpenDate() {
        return transactionOpenDate;
    }

    public void setTransactionOpenDate(LocalDateTime transactionOpenDate) {
        this.transactionOpenDate = transactionOpenDate;
    }

    public LocalDateTime getTransactionCommitDate() {
        return transactionCommitDate;
    }

    public void setTransactionCommitDate(LocalDateTime transactionCommitDate) {
        this.transactionCommitDate = transactionCommitDate;
    }
}

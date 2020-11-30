package online.portowyi.eventlog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Transaction {

    @Id
    private String transactionID;
    private boolean transactionFinished;
    private LocalDateTime transactionOpenDate;
    private LocalDateTime transactionCommitDate;
    private LocalDateTime transactionRollbackDate;

    @Override
    public int hashCode() {
        return Objects.hash(transactionID);
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public boolean isTransactionFinished() {
        return transactionFinished;
    }

    public void setTransactionFinished(boolean transactionCommit) {
        this.transactionFinished = transactionCommit;
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

    public LocalDateTime getTransactionRollbackDate() {
        return transactionRollbackDate;
    }

    public void setTransactionRollbackDate(LocalDateTime transactionRollbackDate) {
        this.transactionRollbackDate = transactionRollbackDate;
    }
}

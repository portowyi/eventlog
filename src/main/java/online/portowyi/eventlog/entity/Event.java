package online.portowyi.eventlog.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(value = "Date")
    private LocalDateTime date;

    @JsonProperty(value = "Event")
    private String event;

    @JsonProperty(value = "UserName")
    private String userName;

    @JsonProperty(value = "TransactionID")
    private String transactionID;

    @JsonProperty(value = "TransactionStatus")
    private String transactionStatus;

    @JsonProperty(value = "Metadata")
    private String metadata;

    @JsonProperty(value = "Comment")
    @Column(length = 1000)
    private String comment;

    @JsonProperty(value = "Data")
    private String data;

    @JsonProperty(value = "MetadataPresentation")
    private String metadataPresentation;

    @JsonProperty(value = "Session")
    private String session;

    @JsonProperty(value = "Connection")
    private String connection;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public String getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMetadataPresentation() {
        return metadataPresentation;
    }

    public void setMetadataPresentation(String metadataPresentation) {
        this.metadataPresentation = metadataPresentation;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @PostPersist
    @PostUpdate
    public void postUpdate(){

    }

}

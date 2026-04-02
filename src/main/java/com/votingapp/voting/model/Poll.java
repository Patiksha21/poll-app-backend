package com.votingapp.voting.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ElementCollection
    @CollectionTable(name = "poll_options", joinColumns = @JoinColumn(name = "poll_id"))
    private List<OptionVote> options = new ArrayList<>();

    // ✅ Default Constructor
    public Poll() {
    }

    // ✅ Parameterized Constructor (Optional but good)
    public Poll(Long id, String question, List<OptionVote> options) {
        this.id = id;
        this.question = question;
        this.options = options;
    }

    // ✅ Getters

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public List<OptionVote> getOptions() {
        return options;
    }

    // ✅ Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOptions(List<OptionVote> options) {
        this.options = options;
    }
}
package com.votingapp.voting.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OptionVote {

    @Column(name = "option_text") // ✅ FIX: avoid reserved keyword
    private String option;

    private Long voteCount = 0L;

    public OptionVote() {
    }

    public OptionVote(String option, Long voteCount) {
        this.option = option;
        this.voteCount = voteCount;
    }

    public String getOption() {
        return option;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
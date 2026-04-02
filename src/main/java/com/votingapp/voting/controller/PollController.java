package com.votingapp.voting.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.votingapp.voting.model.*;
import com.votingapp.voting.request.*;
import com.votingapp.voting.service.PollService;

@CrossOrigin(origins = "http://localhost:4200")  // ✅ CORS FIX
@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    // ✅ Create Poll
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    // ✅ Get All Polls
    @GetMapping
    public List<Poll> getAllPolles() {
        return pollService.getAllPolls();
    }

    // ✅ Get Poll By ID
    @GetMapping("/{id}")   // 🔥 FIXED HERE
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) {
        return pollService.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Vote
    @PostMapping("/vote")
    public ResponseEntity<Poll> vote(@RequestBody Vote vote)
    {
        Poll updatedPoll = pollService.vote(vote.getPollId(), vote.getOptionIndex());
        return ResponseEntity.ok(updatedPoll);
    }
}
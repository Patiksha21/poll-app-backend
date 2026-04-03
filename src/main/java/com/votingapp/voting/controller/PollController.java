package com.votingapp.voting.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.votingapp.voting.model.Poll;
import com.votingapp.voting.request.Vote;
import com.votingapp.voting.service.PollService;

@CrossOrigin(origins = "*")  // ✅ Allow all origins (for testing)
@RestController
@RequestMapping("/api/polls")
public class PollController {

    private final PollService pollService;

    public PollController(PollService pollService) {
        this.pollService = pollService;
    }

    // ✅ Create a new poll
    @PostMapping
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    // ✅ Get all polls
    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    // ✅ Get a single poll by ID
    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) {
        return pollService.getPollById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // ✅ Vote on a poll option
    // Endpoint: POST /api/polls/{id}/vote
    @PostMapping("/{id}/vote")
    public ResponseEntity<Poll> vote(@PathVariable Long id, @RequestBody Vote vote) {
        Poll updatedPoll = pollService.vote(id, vote.getOptionIndex());
        return ResponseEntity.ok(updatedPoll);
    }
}
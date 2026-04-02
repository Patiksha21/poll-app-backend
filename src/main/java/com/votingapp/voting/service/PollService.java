package com.votingapp.voting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.votingapp.voting.model.OptionVote;
import com.votingapp.voting.repository.PollRepository;
import com.votingapp.voting.model.Poll;

@Service
public class PollService {
	private final PollRepository pollRepository;
	public PollService(PollRepository pollRepository)
	{
		this.pollRepository=pollRepository;
	}
	
	public Poll createPoll(Poll poll)
	{
	    // initialize votes for each option
//	 
return pollRepository.save(poll);
	}
	public List<Poll>getAllPolls()
	{
		return pollRepository.findAll();
	}
	public Optional<Poll>getPollById(Long id)
	{
		return pollRepository.findById(id);
		
	}
	public Poll vote(Long pollId, int optionIndex) {

	    Poll poll = pollRepository.findById(pollId)
	            .orElseThrow(() -> new RuntimeException("Poll not found"));

	    // increment vote
	    poll.getOptions().get(optionIndex)
	        .setVoteCount(poll.getOptions().get(optionIndex).getVoteCount() + 1);

	    // save updated poll
	    return pollRepository.save(poll);
	}
	}





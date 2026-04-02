package com.votingapp.voting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.votingapp.voting.model.Poll;
@Repository
public interface PollRepository extends JpaRepository<Poll, Long>{

}

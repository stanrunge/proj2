package com.stanrunge.proj2.controllers.data;

import com.stanrunge.proj2.data.Reward;
import com.stanrunge.proj2.repositories.RewardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rewards/")
public class RewardController {

    private final RewardRepository rewardRepository;

    public RewardController(RewardRepository rewardRepository) {
        this.rewardRepository = rewardRepository;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void createReward(Reward reward) {
        rewardRepository.save(reward);
    }

    @GetMapping("/")
    public Iterable<Reward> getRewards() {
        return rewardRepository.findAll();
    }

    @PutMapping("/")
    public void updateReward(Reward reward) {
        rewardRepository.save(reward);
    }

}

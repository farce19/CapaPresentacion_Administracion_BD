package com.administracion.bd.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with ID: " + id));
    }

    public Rating createRating(Rating rating) {
        if (rating.getUserId() == null || rating.getProviderId() == null || rating.getRating() == null) {
            throw new RuntimeException("User ID, Provider ID, and Rating are mandatory.");
        }
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Rating ratingDetails) {
        Rating existingRating = ratingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rating not found with ID: " + id));

        existingRating.setUserId(ratingDetails.getUserId());
        existingRating.setProviderId(ratingDetails.getProviderId());
        existingRating.setRating(ratingDetails.getRating());
        existingRating.setReview(ratingDetails.getReview());

        return ratingRepository.save(existingRating);
    }

    public void deleteRating(Long id) {
        if (!ratingRepository.existsById(id)) {
            throw new RuntimeException("Rating with ID " + id + " does not exist.");
        }
        ratingRepository.deleteById(id);
    }
}

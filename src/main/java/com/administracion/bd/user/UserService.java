package com.administracion.bd.user;

import com.administracion.bd.booking.BookingRepository;
import com.administracion.bd.rating.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RatingRepository ratingRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(userDetails.getName());
            existingUser.setLastName(userDetails.getLastName());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setLocation(userDetails.getLocation());
            return userRepository.save(existingUser);
        }
        throw new RuntimeException("User not found with ID: " + id);
    }

    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
           
            bookingRepository.deleteAll(bookingRepository.findByUserId(id));
            ratingRepository.deleteAll(ratingRepository.findByUserId(id));
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }
    }
}

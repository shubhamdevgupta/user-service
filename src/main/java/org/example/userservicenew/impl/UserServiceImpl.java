package org.example.userservicenew.impl;

import org.example.userservicenew.entites.Hotel;
import org.example.userservicenew.entites.Rating;
import org.example.userservicenew.entites.User;
import org.example.userservicenew.repositories.UserRepository;
import org.example.userservicenew.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository getUserRepository;

    @Autowired
    RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public User saveUser(User user) {
        String randomId = UUID.randomUUID().toString();
        user.setUserId(randomId);
        return getUserRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = getUserRepository.findAll();
        //List<User> userList1 = restTemplate.getForObject("http://localhost:8083/users/getAllRating/", List.class);
        // userList1.addAll(userList);
        return userList;
    }

    @Override
    public User getUserById(String id) {
        //http://localhost:8083/ratings/user/750c40ec-782a-432a-a2e9-a8c7e92f364f
        User user = getUserRepository.findById(id).orElse(null);
        Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/" + user.getUserId(), Rating[].class);
        logger.info("{}", ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();


        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get hotels
            //http://localhost:8082/hotels/9a3e2e1c-2761-41f6-878a-18bfadf6b50c

            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
            Hotel hotel = forEntity.getBody();

            logger.info("response status code : {}", forEntity.getStatusCode());

            rating.setHotel(hotel);

            return rating;
        }).collect(Collectors.toList());


        user.setRatingList(ratingList);
        return user;
    }

   /* @Override
    public User updateUserbyId(String id) {
        //http://localhost:8083/ratings/user/750c40ec-782a-432a-a2e9-a8c7e92f364f
        User user = getUserRepository.findById(id).orElse(null);
        ArrayList list = restTemplate.getForObject("http://localhost:8083/ratings/user/750c40ec-782a-432a-a2e9-a8c7e92f364f", ArrayList.class);
        logger.info("{}", list);
        return user;
    }*/
}

package org.sample.samplegateway.controller;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.comparator.ByAgeComparator;
import org.sample.samplegateway.model.SortingParam;
import org.sample.samplegateway.model.User;
import org.sample.samplegateway.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public Flux<User> getAllUser(@RequestParam(required = false) String name, @RequestParam(required = false) SortingParam sortingParam) {
        if (name != null && !name.isEmpty()) {
            if (sortingParam != null) {
                return userService.getByName(name)
                        .sort(new ByAgeComparator(sortingParam));
            } else {
                return userService.getByName(name);
            }
        }

        if (sortingParam != null) {
            return userService.getAll()
                    .sort(new ByAgeComparator(sortingParam));
        } else {
            return userService.getAll();
        }
    }

    @PostMapping("/")
    public Mono<User> createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public Mono<User> getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @PutMapping("/")
    public Mono<User> updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable int id) {
        return userService.delete(id);
    }
}

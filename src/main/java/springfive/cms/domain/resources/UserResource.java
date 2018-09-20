package springfive.cms.domain.resources;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfive.cms.domain.models.User;
import springfive.cms.domain.vo.UserRequest;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(tags = "User", description = "User API")
public class UserResource {

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findOne(@PathVariable("id") String id) {
    return ResponseEntity.ok(new User());
  }

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    return ResponseEntity.ok(Arrays.asList(new User(), new User()));
  }

  @PostMapping
  public ResponseEntity<User> newUser(UserRequest User) {
    return new ResponseEntity<>(new User(), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void removeUser(@PathVariable("id") String id) {}

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") String id, UserRequest User) {
    return new ResponseEntity<>(new User(), HttpStatus.OK);
  }
}
